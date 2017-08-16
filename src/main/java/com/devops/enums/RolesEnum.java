package com.devops.enums;

/**
 * Created by XxX on 7/22/2017.
 */
public enum RolesEnum {

    BASIC(1,"ROLE_BASIC"),
    PRO(2,"ROLE_PRO"),
    ADMIN(3,"ROLE_ADMIN");

    private final int id;

    private final String roleName;

    RolesEnum(int id, String role) {
        this.id=id;
        this.roleName =role;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
