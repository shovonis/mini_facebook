package net.therapservices.domain;

/**
 * Created with IntelliJ IDEA.
 * User: rifatul.islam
 * Date: 4/27/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Status {
    private String statusId;
    private String userId;
    private String textContent;

    public Status(String statusId, String userId, String textContent) {
        this.statusId = statusId;
        this.userId = userId;
        this.textContent = textContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "Status{" +
                "statusId='" + statusId + '\'' +
                ", userId='" + userId + '\'' +
                ", textContent='" + textContent + '\'' +
                '}';
    }
}
