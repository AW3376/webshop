package com.webshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
// import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.ArrayList;
import java.util.List;

import com.webshop.dao.ProductsDAO;
import com.webshop.entity.Product;

// DAOクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Repository
public class ProductsDAOImpl implements ProductsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductsDAOImpl() {
        init();
    }

    public void init() {
        // @Autowired がうまく機能しない場合は以下のコメントを外す
        // SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public List<Product> selectOne(Product prod) {
        List<Product> productList = new ArrayList<>();
        //SQL作成
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM products WHERE ");

        // 検索情報確認用。末尾が空白なら検索情報が入っていない
        char blank = ' ';

        // id
        if (prod.getId() > 0) {
            sql.append("id = ");
            sql.append(prod.getId());
        }
        // name
        if (!prod.getName().isEmpty()) {
            if (sql.charAt(sql.length() - 1) != blank) {
                sql.append(" AND ");
            }
            sql.append("name LIKE " + "\"%" + prod.getName() + "%\"");
        }
        // salePrice
        if (prod.getSalePrice() != 0) {
            if (sql.charAt(sql.length() - 1) != blank) {
                sql.append(" AND ");
            }
            sql.append("sale_price = ");
            sql.append(prod.getSalePrice());
        }
        // maker
        if (!prod.getMaker().isEmpty()) {
            if (sql.charAt(sql.length() - 1) != blank) {
                sql.append(" AND ");
            }
            sql.append("maker LIKE " + "\"%" + prod.getMaker() + "%\"");
        }

        // 検索情報がなければ空の結果を返す
        if(sql.toString().equals("SELECT * FROM products WHERE ")) {
            productList.add(new Product());
            return productList;
        }

        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        productList = jdbcTemplate.query(sql.toString(), rowMapper);
        if(CollectionUtils.isEmpty(productList)) {
            productList.add(new Product());
            return productList;
        } else {
            return productList;
        }
    }
}