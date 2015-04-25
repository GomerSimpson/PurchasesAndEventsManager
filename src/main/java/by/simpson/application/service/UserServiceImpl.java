package by.simpson.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.simpson.application.dao.UserDAO;
import by.simpson.application.entity.Event;
import by.simpson.application.entity.Purchase;
import by.simpson.application.entity.User;
import java.sql.Date;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void updateUser(Integer id) {
        userDAO.updateUser(id);
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);

    }

    @Transactional
    public List<User> getListUsers() {
        return userDAO.getListUsers();
    }

    @Transactional
    public User getUser(Integer id) {
        return userDAO.getUser(id);
    }

    @Transactional
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

    @Transactional
    public List<Event> getUserEvents(String login, Date date) {
        return userDAO.getUserEvents(login, date);
    }

    @Transactional
    public void setEvent(String login, Event event) {
        userDAO.setEvent(login, event);
    }

    @Transactional
    public void deleteEvent(Integer id) {
        userDAO.deleteEvent(id);
    }

    @Transactional
    public List<Purchase> getUserPurchases(String login, Date date){
        return userDAO.getUserPurchases(login, date);
    }

    @Transactional
    public void setPurchase(String login, Purchase purchase){
        System.out.println("setPurchase from UserServiceImpl.java");
        userDAO.setPurchase(login, purchase);
    }

    @Transactional
    public void deletePurchase(Integer id){
        userDAO.deletePurchase(id);
    }
}
