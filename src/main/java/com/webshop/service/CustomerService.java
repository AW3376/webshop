package com.webshop.service;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;

public interface CustomerService {
	public ResultDTO<Customer> selectAll();
	// public ResultDTO<Customer> insertOne();
	// public ResultDTO<Customer> updateOne();
	// public ResultDTO<Customer> deleteOne();
}