package net.therapservices.domain;

/**
 * Created with IntelliJ IDEA.
 * UserDao: rifatul.islam
 * Date: 4/27/14
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserPersonalInfo {
    private String address;
    private String mobileNumber;
    private byte[] profilePicture;
    private byte[] coverPhoto;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(byte[] coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
