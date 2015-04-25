package by.simpson.application.dao;

import by.simpson.application.entity.Event;
import by.simpson.application.entity.Purchase;
import java.util.List;

import by.simpson.application.entity.User;
import java.sql.Date;

public interface UserDAO{
	public void addUser(User user);
	public void updateUser(Integer id);
	public void deleteUser(Integer id);
	public List<User> getListUsers();
	public User getUser(Integer id);
	public User getUser(String name);
        public List<Event> getUserEvents(String login, Date date);
        public void setEvent(String login, Event event);
        public void deleteEvent(Integer id);
        public List<Purchase> getUserPurchases(String login, Date date);
        public void setPurchase(String login, Purchase purchase);
        public void deletePurchase(Integer id);
}
