package by.simpson.application.dao;

import by.simpson.application.entity.Event;
import by.simpson.application.entity.Purchase;
import by.simpson.application.entity.Role;
import by.simpson.application.entity.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDAOImpl implements UserDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void updateUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            user.setEmail(user.getEmail());
            sessionFactory.getCurrentSession().update(user);
        }
    }

    public void deleteUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);

        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getListUsers() {
        List<User> list = sessionFactory.getCurrentSession().createQuery("from User")
                .list();

        return list;
    }

    public User getUser(Integer id) {
        //User user = new User();
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        /*
         user.setId_user(tempUser.getId_user());
         user.setFirstName(tempUser.getFirstName());
         user.setLastName(tempUser.getLastName());
         */
        for (Event e : user.getEvents()) {
            //    System.out.println(e.getName());
        }

        for (Purchase p : user.getPurchases()) {
            //  System.out.println(p.getName());
        }

        for (Role r : user.getRoles()) {
            //    System.out.println(r.getRole());
        }

        /*user.setEmail(tempUser.getEmail());
         user.setLogin(tempUser.getLogin());
         System.out.println(tempUser);*/
        return user;
    }

    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public User getUser(String login) {
        List<User> users = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).add(Expression.like("login", login)).list();

        if (users.isEmpty()) {
            return null;
        }

        User user = users.get(0);

        for (Event e : user.getEvents()) {
            //      System.out.println(e.getName());
        }

        for (Purchase p : user.getPurchases()) {
            //    System.out.println(p.getName());
        }

        for (Role r : user.getRoles()) {
            //  System.out.println(r.getRole());
        }

        return user;
    }

    public void setEvent(String login, Event event) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Expression.like("login", login)).list().get(0);
        user.setEvent(event);
        sessionFactory.getCurrentSession().update(user);
    }

    public List<Event> getUserEvents(String login, Date date) {

        /* List<Event> events = (List<Event>) sessionFactory.getCurrentSession().createCriteria(User.class)
         .add(Expression.like("id", id)).add(Expression.like("date", date)).list();*/
        User user = getUser(login);
        List<Event> events = new ArrayList<Event>();

        for (Event e : user.getEvents()) {
            if (e.getDate().getDate() == date.getDate() && e.getDate().getMonth() == date.getMonth() && e.getDate().getYear() == date.getYear()) {
                //          e.setUser(null);
                events.add(e);

            }
            //      System.out.println(e.getDate().getDate() +  " or  " + date.getDate());
            //    System.out.println((e.getDate().getDate() == date.getDate()) + " " + " " + (e.getDate().getMonth() == date.getMonth()) + " " + (e.getDate().getYear() == date.getYear()));
        }

        //JOptionPane.showMessageDialog(null, events);
        return events;

    }

    public void deleteEvent(Integer id) {
        Event event = (Event) sessionFactory.getCurrentSession().load(
                Event.class, id);

        if (null != event) {
            sessionFactory.getCurrentSession().delete(event);
        }
    }

    public List<Purchase> getUserPurchases(String login, Date date) {
        User user = getUser(login);
        List<Purchase> purchases = new ArrayList<Purchase>();

        for (Purchase p : user.getPurchases()) {
            if (p.getDate().getDate() == date.getDate() && p.getDate().getMonth() == date.getMonth() && p.getDate().getYear() == date.getYear()) {
                //          e.setUser(null);
                purchases.add(p);

            }
            //      System.out.println(e.getDate().getDate() +  " or  " + date.getDate());
            //    System.out.println((e.getDate().getDate() == date.getDate()) + " " + " " + (e.getDate().getMonth() == date.getMonth()) + " " + (e.getDate().getYear() == date.getYear()));
        }

        //JOptionPane.showMessageDialog(null, events);
        return purchases;
    }

    public void setPurchase(String login, Purchase purchase) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Expression.like("login", login)).list().get(0);
        user.setPurchase(purchase);
        sessionFactory.getCurrentSession().update(user);
    }

    public void deletePurchase(Integer id) {
        Purchase purchase = (Purchase) sessionFactory.getCurrentSession().load(
                Purchase.class, id);

        if (null != purchase) {
            sessionFactory.getCurrentSession().delete(purchase);
        }
    }
}
