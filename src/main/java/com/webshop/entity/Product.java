package com.webshop.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int salePrice;
    private int purchasePrice;
    private int stock;
    private String maker;

    public Product() {
    }

    public Product(int id, String name, int salePrice, int purchasePrice, int stock, String maker) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.maker = maker;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalePrice() {
        return this.salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", salePrice='" + getSalePrice() + "'" +
            ", purchasePrice='" + getPurchasePrice() + "'" +
            ", stock='" + getStock() + "'" +
            ", maker='" + getMaker() + "'" +
            "}";
    }

}
