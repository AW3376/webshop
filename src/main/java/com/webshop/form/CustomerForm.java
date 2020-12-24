package com.webshop.form;

import com.webshop.entity.Customer;

public class CustomerForm {
    // TODO バリデーションはここで入れられそう
    // @size(min=0, max=127)
    private int number;
    private String id;
    private String password;
    private String name;
    private String prefecture;
    private String city;
    private String phone;

    public Customer toEntity(){
        Customer cust = new Customer();
        cust.setNumber(this.number);
        cust.setId(this.id);
        cust.setPassword(this.password);
        cust.setName(this.name);
        cust.setPrefecture(this.prefecture);
        cust.setCity(this.city);
        cust.setPhone(this.phone);
        return cust;
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
}
