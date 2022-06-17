package org.linkdew.daopattern.entities;

public class User {
    private Long userId;
    private String username;
    private Long roleId;
    private String password;
    private String email;

    @Override
    public String toString(){
        return "User id: " + userId.toString() +
                "\tUsername: " + username +
                "\tRole id: " + roleId.toString() +
                "\tPass: " + password +
                "\tEmail: " + email;
    }

    public User(Long userId, String username, Long roleId, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.roleId = roleId;
        this.password = password;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
