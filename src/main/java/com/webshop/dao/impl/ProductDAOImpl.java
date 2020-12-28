package com.webshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
// import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import com.webshop.dao.ProductDAO;
import com.webshop.entity.Product;

// DAOクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductDAOImpl() {
        init();
    }

    public void init() {
        // @Autowired がうまく機能しない場合は以下のコメントを外す
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void insertProduct(Product prod) {
        int result;
        if(StringUtils.hasText(prod.getMaker())) {
            result = jdbcTemplate.update("INSERT INTO products" +
                        "(id, name, sale_price, purchase_price, stock) VALUES (?, ?, ?, ?, ?)",
                        prod.getId(),
                        prod.getName(),
                        prod.getSalePrice(),
                        prod.getPurchasePrice(),
                        prod.getStock());
        } else {
            result = jdbcTemplate.update("INSERT INTO products" +
                        "(id, name, sale_price, purchase_price, stock, maker) VALUES (?, ?, ?, ?, ?, ?)",
                        prod.getId(),
                        prod.getName(),
                        prod.getSalePrice(),
                        prod.getPurchasePrice(),
                        prod.getStock(),
                        prod.getMaker());
        }
        System.out.println("result = " + result);
    }

    @Override
    public List<Product> selectProducts(Product prod) {
        List<Product> productList = new ArrayList<>();
        // TODO ループ処理
        //SQL作成
        StringBuilder sql = new StringBuilder();
        String sqlBase = "SELECT * FROM products WHERE ";
        sql.append(sqlBase);

        // id
        if (prod.getId() > 0) {
            sql.append("id = " + prod.getId());
        }
        // name
        if (StringUtils.hasText(prod.getName())) {
            if (isNeededConjunction(sql)) {
                sql.append(" AND ");
            }
            sql.append("name LIKE " + "\"%" + prod.getName() + "%\"");
        }
        // sale_price
        if (prod.getSalePrice() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(" AND ");
            }
            sql.append("sale_price = " + prod.getSalePrice());
        }
        // purchase_price
        if (prod.getPurchasePrice() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(" AND ");
            }
            sql.append("purchase_price = " + prod.getPurchasePrice());
        }
        // stock
        if (prod.getStock() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(" AND ");
            }
            sql.append("stock = " + prod.getStock());
        }
        // maker
        if (StringUtils.hasText(prod.getMaker())) {
            if (isNeededConjunction(sql)) {
                sql.append(" AND ");
            }
            sql.append("maker LIKE " + "\"%" + prod.getMaker() + "%\"");
        }

        // 検索情報がなければ空の結果を返す
        if(sql.toString().equals(sqlBase)) {
            productList.add(new Product());
            return productList;
        }

        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        productList = jdbcTemplate.query(sql.toString(), rowMapper);
        // 検索結果が空なら空のentity入れとく
        if(CollectionUtils.isEmpty(productList)) {
            productList.add(new Product());
        }
        return productList;
    }

    @Override
    public void updateProduct(Product prod) {
        int result;

        //SQL作成
        StringBuilder sql = new StringBuilder();
        String sqlBase = "update products set ";
        sql.append(sqlBase);

        // TODO ループで処理できそう フィールド名取得てobjectクラス？
        // name
        if (StringUtils.hasText(prod.getName())) {
            sql.append("name = \"" + prod.getName() + "\"");
        }
        // sale_price
        if (prod.getSalePrice() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("sale_price = " + prod.getSalePrice());
        }
        // purchase_price
        if (prod.getPurchasePrice() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("purchase_price = " + prod.getPurchasePrice());
        }
        // stock
        if (prod.getStock() >= 0) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("stock = \"" + prod.getStock() + "\"");
        }
        // maker
        if (StringUtils.hasText(prod.getMaker())) {
            if (isNeededConjunction(sql)) {
                sql.append(", ");
            }
            sql.append("maker = \"" + prod.getMaker() + "\"");
        }

        // 変更箇所がなければ変更しない
        // TODO 要素をそれぞれ比較してできるのが理想かな？
        sql.append("where id = " + prod.getId());

        result = jdbcTemplate.update(sql.toString());
        System.out.println("result = " + result);
    }

    @Override
    public void deleteProductById(int id) {
        int result;
        result = jdbcTemplate.update("DELETE FROM products WHERE id = ?", id);
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