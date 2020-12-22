package com.webshop.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int number;
    private String id;
    private String password;
    private String name;
    private String prefecture;
    private String city;
    private String phone;

    public Customer() {
    }

    public Customer(int number, String id, String password, String name, String prefecture, String city, String phone) {
        this.number = number;
        this.id = id;
        this.password = password;
        this.name = name;
        this.prefecture = prefecture;
        this.city = city;
        this.phone = phone;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", id='" + getId() + "'" +
            ", password='" + getPassword() + "'" +
            ", name='" + getName() + "'" +
            ", prefecture='" + getPrefecture() + "'" +
            ", city='" + getCity() + "'" +
            ", phone='" + getPhone() + "'" +
            "}";
    }
}