package net.therapservices.controller;

import net.therapservices.dao.UserDao;
import net.therapservices.dao.UserImp;
import net.therapservices.domain.Friendship;
import net.therapservices.domain.Status;
import net.therapservices.domain.User;
import net.therapservices.util.file.PropManager;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * UserCont: rifatul.islam
 * Date: 4/27/14
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserCont {
    private UserDao userDao;
    private Properties properties;

    public UserCont() {
        this.userDao = new UserImp();
    }

    public void addUser() {
        try {
            properties = PropManager.loadProperties("input_file/user.properties");
            userDao.save(new User(properties.getProperty("user_id"), properties.getProperty("firstname"),
                    properties.getProperty("lastname"), properties.getProperty("password"), properties.getProperty("email"),
                    properties.getProperty("dob"), properties.getProperty("gender")));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public List<Friendship> getMutualFriend(String userId, String friendId) {
        return userDao.findMutualFriend(userId, friendId);
    }

    public void deleteUser(String userId) {
        userDao.deleteUser(userId);
    }

    public void addStatus() {
        try {
            properties = PropManager.loadProperties("input_file/status.properties");
            userDao.addStatus(new Status(properties.getProperty("s_id"), properties.getProperty("user_id"),
                    properties.getProperty("text_content")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
