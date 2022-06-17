package org.linkdew.daopattern.entities;

public class Role {
    private Long roleId;
    private String rolename;

    public Role(Long roleId, String rolename) {
        this.roleId = roleId;
        this.rolename = rolename;
    }

    @Override
    public String toString(){
        return "Role id: " + roleId.toString() +
                "\tRole: " + rolename;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
