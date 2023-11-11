package com.example.coursework;

public class Role {
    int ID;
    String Role;
    Role(){}

    Role(int ID, String Role){
        this.ID = ID;
        this.Role = Role;
    }

    public int getID() {
        return ID;
    }

    public String getRole() {
        return Role;
    }
}
