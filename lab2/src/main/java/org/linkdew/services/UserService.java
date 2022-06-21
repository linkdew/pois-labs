package org.linkdew.services;

import org.linkdew.daopattern.dao.UserDAO;
import org.linkdew.daopattern.entities.User;

public class UserService {
    public User login(String username, String password) {
        UserDAO userDao = new UserDAO();
        User user = userDao.findByUsername(username) ;
        userDao.closeConnection();

        if (user == null){
            return null;
        }
        if (password.equals(user.getPassword())){
            System.out.println("user: " + user.toString());
            return user;
        }
        else{
            System.out.println("user: " + user);
            return null;
        }

    }
}
