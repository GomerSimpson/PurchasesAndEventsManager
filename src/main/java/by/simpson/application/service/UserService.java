package by.simpson.application.service;

import java.util.List;

import by.simpson.application.entity.User;

public interface UserService {
	public void addUser(User user);
	public void updateUser(Integer id);
	public void deleteUser(Integer id);
	public List<User> getListUsers();
	public User getUser(Integer id);
	public User getUser(String login);
}
