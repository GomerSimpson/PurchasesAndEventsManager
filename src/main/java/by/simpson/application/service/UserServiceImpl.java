package by.simpson.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.simpson.application.dao.UserDAO;
import by.simpson.application.entity.User;

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
}
