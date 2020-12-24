package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Customer;

public interface CustomerDAO {
    public List<Customer> selectAll();
    public void insertCustomer(Customer cust);
    public List<Customer> selectCustomers(Customer cust);
    public void updateCustomer(Customer cust);
    public void deleteCustomer(int num);
}