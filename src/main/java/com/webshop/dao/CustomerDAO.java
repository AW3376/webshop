package com.webshop.dao;

import java.util.List;

import com.webshop.entity.Customer;

public interface CustomerDAO {
    public List<Customer> selectAll();
    public void insertOne(Customer cust);
    public Customer selectOneById(String id);
    public void updateOne(Customer cust);
    public void deleteOneById(String id);
}