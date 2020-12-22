package com.webshop.service;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;

public interface ProductsService {
	public ResultDTO<Product> showOne(ProductForm prod);
}