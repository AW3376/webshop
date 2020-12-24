package com.webshop.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
// import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.util.StringUtils;

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
    public void insertCustomer(Customer cust) {
        int result;
        if(StringUtils.hasText(cust.getPhone())) {
            result = jdbcTemplate.update("INSERT INTO customers" +
                        "(id, password, name, prefecture, city) VALUES (?, ?, ?, ?, ?)",
                        cust.getId(),
                        cust.getPassword(),
                        cust.getName(),
                        cust.getPrefecture(),
                        cust.getCity());
        } else {
            result = jdbcTemplate.update("INSERT INTO customers" +
                        "(id, password, name, prefecture, city, phone) VALUES (?, ?, ?, ?, ?, ?)",
                        cust.getId(),
                        cust.getPassword(),
                        cust.getName(),
                        cust.getPrefecture(),
                        cust.getCity(),
                        cust.getPhone());
        }
        System.out.println("result = " + result);
    }

    @Override
    public Customer selectCustomers(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCustomer(Customer cust) {
        int result;

        //SQL作成
        StringBuilder sql = new StringBuilder();
        String sqlBase = "update customers set ";
        sql.append(sqlBase);

        // id
        if (StringUtils.hasText(cust.getId())) {
            sql.append("id = \"" + cust.getId() + "\"");
        }
        // password
        if (StringUtils.hasText(cust.getPassword())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("password = \"" + cust.getPassword() + "\"");
        }
        // name
        if (StringUtils.hasText(cust.getName())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("password = \"" + cust.getPassword() + "\"");
        }
        // prefecture
        if (StringUtils.hasText(cust.getPrefecture())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("prefecture = \"" + cust.getPrefecture() + "\"");
        }
        // city
        if (StringUtils.hasText(cust.getCity())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("city = \"" + cust.getCity() + "\"");
        }
        // phone
        if (StringUtils.hasText(cust.getPhone())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("phone = \"" + cust.getPhone() + "\"");
        }

        // 変更箇所がなければ変更しない
        if(sql.toString().equals(sqlBase)) {
            // customerList.add(new Customer());
        }

        sql.append("where number = " + cust.getNumber());

        System.out.println("sssssssssssssssssssssssssssssssssssssssss");
        System.out.println(sql.toString());

        result = jdbcTemplate.update(sql.toString());
        System.out.println("result = " + result);
    }


    @Override
    public void deleteCustomer(int num) {
        int result;
        result = jdbcTemplate.update("DELETE FROM customers WHERE number = ?", num);
        System.out.println("result = " + result);
    }

    // SQL作成の際に末尾が空白じゃなければ接続詞が必要
    public boolean isNeededConjunction(StringBuilder sb) {
        if(!Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            return true;
        } else {
            return false;
        }
    }

}
