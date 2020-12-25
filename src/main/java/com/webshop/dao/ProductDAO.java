package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Product;

public interface ProductDAO {
    public void insertProduct(Product prod);
    public List<Product> selectProducts(Product prod);
    public void updateProduct(Product prod);
    public void deleteProductById(int id);
}