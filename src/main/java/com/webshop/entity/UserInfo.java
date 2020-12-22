package com.webshop.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String pass;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
