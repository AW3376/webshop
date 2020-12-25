package com.webshop.controller;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;
import com.webshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// コントローラクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Controller
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private ProductService prodService;

    @ModelAttribute("prodForm")
    public ProductForm setUpForm() {
        return new ProductForm();
    }

    @GetMapping("")
    public String productsTopPage() {
        return "products";
    }

    @PostMapping(value = "execute", params = "searchProducts")
    public String searchCutomer(@ModelAttribute ProductForm prodForm, BindingResult bs, Model model) {
        // TODO err
        System.out.println("contttttttttttttttttt");
        System.out.println(prodForm.toString());
        if(bs.hasErrors()) { System.out.println(bs.toString()); }
        // execute service
        ResultDTO<Product> dto = prodService.selectProducts(prodForm);
        model.addAttribute("list", dto.getList());

        return "products";
    }
}