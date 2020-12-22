package com.webshop.service.impl;

import java.util.List;

import com.webshop.dao.CustomerDAO;
import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;
import com.webshop.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;

// サービスクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Service
public class CustomerServiceImpl implements CustomerService {

	// フィールド単位で付与する。付与されたフィールドの型と合うBeanを自動的に
	// DIしてくれる。複数ある場合は@Qualifierを使用して一意に識別させる
    @Autowired
	private CustomerDAO dao;

    public CustomerServiceImpl() {
        init();
    }

    public void init(){
		// @Autowired がうまく機能しない場合は以下のコメントを外す
		// SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public ResultDTO<Customer> execute(Customer cust) {
        ResultDTO<Customer> rs = new ResultDTO<>();

        // // INSERT
		// dao.insertOne(model);

		// // UPDATE
		// model.setName("廃止");
		// dao.updateOne(model);

		// // DELETE
		// dao.deleteOneById(model.getId());

		// SELECT 複数
		List<Customer> list = dao.getAll();
		rs.setList(list);

		return rs;
    }
}
