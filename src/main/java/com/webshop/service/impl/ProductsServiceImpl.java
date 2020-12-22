package com.webshop.service.impl;

import com.webshop.dao.ProductsDAO;
import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;
import com.webshop.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;

// サービスクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Service
public class ProductsServiceImpl implements ProductsService {

	// フィールド単位で付与する。付与されたフィールドの型と合うBeanを自動的に
	// DIしてくれる。複数ある場合は@Qualifierを使用して一意に識別させる
    @Autowired
	private ProductsDAO dao;

    public ProductsServiceImpl() {
        init();
    }

    public void init() {
		// @Autowired がうまく機能しない場合は以下のコメントを外す
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public ResultDTO<Product> showOne(ProductForm prodForm) {
        // formから検索用entityに変換
        Product prod = prodForm.toEntity();
        // READ
        ResultDTO<Product> rs = new ResultDTO<>();
        rs.setList(dao.selectOne(prod));

        return rs;
    }

}
