package code;

public interface UserInterface {
    int getUserID();
    void setUserID(int userID);

    String getUserName();
    void setUserName(String userName);

    String getPassword();
    void setPassword(String password);

    String getEmail();
    void setEmail(String email);

    UserType getUserType();
    void setUserType(UserType userType);

}
