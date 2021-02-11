package com.example.whatsapp.Model;

public class Users {
    String profilepic;
    String userName;
    String mail;
    String userId;
    String lastMessage;
    String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Users(String profilepic, String userName, String mail, String userId, String lastMessage, String password) {
        this.profilepic = profilepic;
        this.userName = userName;
        this.mail = mail;
        this.password = password;

        this.userId = userId;
        this.lastMessage = lastMessage;
    }
    //Empty Constructor
    public Users(){}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //For SignUp
    public Users(String userName,String mail,String password) {
        this.userName = userName;
        this.mail = mail;
        this.password = password;
    }



    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
}
