package com.postgres_nosql.model.info;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by igor on 12/4/16.
 */
public class UserInfo implements Info {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-SS")
    private Date lastEnter;
    private String userName;
    private String userEmail;

    public UserInfo() {
    }

    public UserInfo(Date lastEnter, String userName, String userEmail) {
        this.lastEnter = lastEnter;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Date getLastEnter() {
        return lastEnter;
    }

    public void setLastEnter(Date lastEnter) {
        this.lastEnter = lastEnter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (!lastEnter.equals(userInfo.lastEnter)) return false;
        if (!userName.equals(userInfo.userName)) return false;
        return userEmail.equals(userInfo.userEmail);

    }

    @Override
    public int hashCode() {
        int result = lastEnter.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + userEmail.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "lastEnter=" + lastEnter +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
