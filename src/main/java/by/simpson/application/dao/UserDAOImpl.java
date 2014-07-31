package by.simpson.application.dao;

import by.simpson.application.entity.Event;
import by.simpson.application.entity.Purchase;
import by.simpson.application.entity.Role;
import by.simpson.application.entity.User;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
    private SessionFactory sessionFactory;	
	
	public void addUser(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	public void updateUser(Integer id){
		User user = (User)sessionFactory.getCurrentSession().load(
				User.class, id);
		if (null != user) {
                    	user.setEmail(user.getEmail());
			sessionFactory.getCurrentSession().update(user);
		}	
	}
	
	public void deleteUser(Integer id){
		User user = (User)sessionFactory.getCurrentSession().load(
				User.class, id);
		
		if (null != user) {
			sessionFactory.getCurrentSession().delete(user);
		}		
	}
	
	@SuppressWarnings("unchecked")
	public  List<User> getListUsers(){
		return sessionFactory.getCurrentSession().createQuery("from User")
				.list();
	}
	
	public User getUser(Integer id){
		//User user = new User();
		User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
		/*
		user.setId_user(tempUser.getId_user());
		user.setFirstName(tempUser.getFirstName());
		user.setLastName(tempUser.getLastName());
		*/
		for(Event e : user.getEvents())
			System.out.println(e.getName());
		
		for(Purchase p : user.getPurchases())
			System.out.println(p.getName());
                
                for(Role r : user.getRoles())
			System.out.println(r.getRole());

		
		/*user.setEmail(tempUser.getEmail());
		user.setLogin(tempUser.getLogin());
		System.out.println(tempUser);*/
		return user;
	}
	
        @SuppressWarnings("SuspiciousIndentAfterControlStatement")
	public User getUser(String login){
            User user = (User)sessionFactory.getCurrentSession().createCriteria(User.class).add(Expression.like("login", login)).list().get(0);
            
            for(Event e : user.getEvents())
		System.out.println(e.getName());
		
            for(Purchase p : user.getPurchases())
		System.out.println(p.getName());
		
            for(Role r : user.getRoles())
		System.out.println(r.getRole());            

		return user;
	}
}