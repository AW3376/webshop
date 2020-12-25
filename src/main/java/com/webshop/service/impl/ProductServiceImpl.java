package com.webshop.service.impl;

import com.webshop.dao.ProductDAO;
import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;
import com.webshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;

// サービスクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Service
public class ProductServiceImpl implements ProductService {

	// フィールド単位で付与する。付与されたフィールドの型と合うBeanを自動的に
	// DIしてくれる。複数ある場合は@Qualifierを使用して一意に識別させる
    @Autowired
	private ProductDAO dao;

    public ProductServiceImpl() {
        init();
    }

    public void init(){
		// @Autowired がうまく機能しない場合は以下のコメントを外す
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    // // SELECT ALL DATA
    // public ResultDTO<Product> selectAll() {
    //     ResultDTO<Product> rs = new ResultDTO<>();

	// 	List<Product> list = dao.selectAll();
	// 	rs.setList(list);

	// 	return rs;
    // }

    // SELECT
    public ResultDTO<Product> selectProducts(ProductForm prodForm) {
        System.out.println("ssssssssssssssssssssss");
        System.out.println(prodForm.toString());
        Product prod = prodForm.toEntity();
        ResultDTO<Product> rs = new ResultDTO<>();
        rs.setList(dao.selectProducts(prod));

		return rs;
    }

    // INSERT
    public void insertProduct(ProductForm prodForm) {
        Product product = prodForm.toEntity();
		dao.insertProduct(product);
    }

    // UPDATE
    public void updateProduct(ProductForm prodForm) {
        Product product = prodForm.toEntity();
        dao.updateProduct(product);
    }

    // DELETE
    public void deleteProduct(ProductForm prodForm) {
	    dao.deleteProductById(prodForm.getId());
    }

}
