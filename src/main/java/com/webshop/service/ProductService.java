package com.webshop.service;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;

public interface ProductService {

    // SELECT
    public ResultDTO<Product> selectProducts(ProductForm prodForm);

    // INSERT
    public void insertProduct(ProductForm prodForm);

    // UPDATE
    public void updateProduct(ProductForm prodForm);

    // DELETE
    public void deleteProduct(ProductForm prodForm);
}