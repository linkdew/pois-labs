package org.linkdew.daopattern.entities;

public class Role {
    private Long userId;
    private String rolename;

    public Role(Long userId, String rolename) {
        this.userId = userId;
        this.rolename = rolename;
    }

    @Override
    public String toString(){
        return "User id: " + userId.toString() +
                "\tRole: " + rolename;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
