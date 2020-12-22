package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Product;

public interface ProductsDAO {
    public List<Product> selectOne(Product prod);
}