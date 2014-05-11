package net.therapservices.dao;

import net.therapservices.domain.Friendship;
import net.therapservices.domain.Status;
import net.therapservices.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserDao: rifatul.islam
 * Date: 4/27/14
 * Time: 11:26 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public void save(User user);

    public User getUserById(String userId);

    public List<User> getAllUser();

    public void deleteUser(String userId);

    public List<Friendship> findMutualFriend(String userId, String friendId);

    public void addStatus(Status status);

    public List<Status> showStatus();

    public void addProfilePicture();


}
