package com.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @Column(name="playerid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer playerID;

    @Column(name="username")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="isadmin")
    private Boolean isAdmin = false;

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
