package com.webshop.service;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;

public interface CustomerService {
	public ResultDTO<Customer> execute(Customer cust);
}