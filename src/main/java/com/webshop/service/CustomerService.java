package com.webshop.service;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;
import com.webshop.form.CustomerForm;

public interface CustomerService {
	public ResultDTO<Customer> selectAll();
	public void insertCustomer(CustomerForm custForm);
	public void updateCustomer(CustomerForm custForm);
	public void deleteCustomer(CustomerForm custForm);
}