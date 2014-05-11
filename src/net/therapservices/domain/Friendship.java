package net.therapservices.domain;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/27/14
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Friendship {

    private String userId;
    private String friendId;

    public Friendship(String userId, String friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public String toString() {
        return "Friendship{" +
                "userId='" + userId + '\'' +
                ", friendId='" + friendId + '\'' +
                '}';
    }
}
