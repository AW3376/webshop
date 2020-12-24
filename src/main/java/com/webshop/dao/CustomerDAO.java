package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Customer;

public interface CustomerDAO {
    public List<Customer> selectAll();
    public void insertCustomer(Customer cust);
    public Customer selectCustomers(String id);
    public void updateCustomer(Customer cust);
    public void deleteCustomer(int num);
}