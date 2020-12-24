package com.webshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.webshop.dao.CustomerDAO;
import com.webshop.entity.Customer;

// DAOクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Repository
public class CustomerDAOImple implements CustomerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CustomerDAOImple() {
        init();
    }

    public void init() {
        // @Autowired がうまく機能しない場合は以下のコメントを外す
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public List<Customer> selectAll() {
        // 他にRowMapperとMapを使った取得方法があるが、使えるなら以下が一番楽
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        List<Customer> customerList = jdbcTemplate.query("SELECT * FROM customers", rowMapper);
        return customerList;
    }

    @Override
    public void insertOne(Customer cust) {
        // TODO Auto-generated method stub

    }

    @Override
    public Customer selectCustomers(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateOne(Customer cust) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteOne(String id) {
        // TODO Auto-generated method stub

    }
}
