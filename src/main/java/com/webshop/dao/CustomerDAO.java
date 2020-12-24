package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Customer;

public interface CustomerDAO {
    public List<Customer> selectAll();
    public void insertOne(Customer cust);
    public Customer selectCustomers(String id);
    public void updateOne(Customer cust);
    public void deleteOne(String id);
}