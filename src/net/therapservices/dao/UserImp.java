package net.therapservices.dao;

import net.therapservices.domain.Friendship;
import net.therapservices.domain.Status;
import net.therapservices.domain.User;
import net.therapservices.util.db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserDao: rifatul.islam
 * Date: 4/27/14
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserImp implements UserDao {

    private String query;

    @Override
    public void save(User user) {

        query = "INSERT INTO `facebook`.`user` (`u_id`, `firstname`, `lastname`, `password`, `email`, `dob`, `gender`)" +
                " VALUES (?, ?, ?, ?,?,?,?)";

        String userId = user.getUserId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String password = user.getPassword();
        String email = user.getEmail();
        String dob = user.getDob();
        String gender = user.getGender();

        Database.insertUpdateDeleteQuery(query, userId, firstName, lastName, password, email, dob, gender);
        Database.closeConnection();

    }

    @Override
    public User getUserById(String userId) {
        query = "SELECT * FROM `user` WHERE u_id= ? ";
        ResultSet resultSet = Database.executeQuery(query, userId);
        User user = null;
        try {
            while (resultSet.next()) {
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Database.closeConnection();

        return user;
    }

    @Override
    public List<User> getAllUser() {
        query = "SELECT * FROM `user`";
        List<User> userList = new ArrayList<User>();
        ResultSet resultSet = Database.executeQuery(query);
        User user = null;
        try {
            while (resultSet.next()) {
                userList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void deleteUser(String userId) {
        query = "DELETE  FROM `user` WHERE u_id=?";
        Database.insertUpdateDeleteQuery(query, userId);

    }

    @Override
    public List<Friendship> findMutualFriend(String userId, String friendId) {
        query = "SELECT friend_id FROM friendship WHERE user_id= ? and friend_id IN " +
                "(SELECT friend_id FROM friendship WHERE user_id=?)";
        List<Friendship> mutualFriendList = new ArrayList<Friendship>();
        ResultSet resultSet = Database.executeQuery(query, userId, friendId);

        try {
            while (resultSet.next()) {
                mutualFriendList.add(new Friendship(userId, resultSet.getString("friend_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mutualFriendList;
    }

    @Override
    public void addStatus(Status status) {
        query = "INSERT INTO `facebook`.`posts` (`s_id`, `u_id`, `text_content`)" +
                " VALUES (?, ?, ?)";
        Database.insertUpdateDeleteQuery(query, status.getStatusId(), status.getUserId(), status.getTextContent());
    }

    @Override
    public List<Status> showStatus() {
        query="";
        return null;
    }

    @Override
    public void addProfilePicture() {

    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString("u_id"), resultSet.getString("firstname"),
                resultSet.getString("lastname"), resultSet.getString("password"), resultSet.getString("email"),
                resultSet.getString("dob"), resultSet.getString("gender"));
    }

}
