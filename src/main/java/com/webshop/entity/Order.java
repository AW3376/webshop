package com.webshop.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String customer_id;
    private int product_id;
    private int ammount;
    private int order_price;
    private String status;

    public Order() {
    }

    public Order(int id, String customer_id, int product_id, int ammount, int order_price, String status) {
        this.id = id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.ammount = ammount;
        this.order_price = order_price;
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return this.product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAmmount() {
        return this.ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getOrder_price() {
        return this.order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customer_id='" + getCustomer_id() + "'" +
            ", product_id='" + getProduct_id() + "'" +
            ", ammount='" + getAmmount() + "'" +
            ", order_price='" + getOrder_price() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }

}
