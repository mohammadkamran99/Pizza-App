package com.wave17.CustomerService.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int userId;
    private String name;
    private String emailId;
    private String password;
    private String mobileNo;
//    @OneToMany(targetEntity = Pizza.class,cascade = CascadeType.ALL)
//    @JoinColumn(name = "cp_fk",referencedColumnName = "userId")
//    private List<Pizza> pizzas;

    public User() {
    }

    public User(int userId, String name, String emailId, String password, String mobileNo) {
        this.userId = userId;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.mobileNo = mobileNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
