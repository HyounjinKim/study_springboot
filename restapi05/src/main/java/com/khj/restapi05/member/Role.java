package com.khj.restapi05.member;

public enum Role {
    USER,ADMIN;

    public static Role fromString(String userRole){
        for (Role role : Role.values()){
            if (role.toString().equalsIgnoreCase(userRole)){
                return role;
            }
        }
        return null;
    }
}
