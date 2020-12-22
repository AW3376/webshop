package com.webshop.form;

import com.webshop.entity.Product;

public class ProductForm {
    // TODO バリデーションはここで入れられそう
    // @size(min=0, max=127)
    private int id;

    private String name;

    private int salePrice;

    private int purchasePrice;

    private int stock;

    private String maker;

    public Product toEntity() {
        Product prod = new Product();
        prod.setId(this.getId());
        prod.setName(this.getName());
        prod.setSalePrice(this.getSalePrice());
        prod.setPurchasePrice(this.getPurchasePrice());
        prod.setStock(this.getStock());
        prod.setMaker(this.getMaker());
        return prod;
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
}
