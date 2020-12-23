package com.webshop.controller;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Product;
import com.webshop.form.ProductForm;
import com.webshop.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// コントローラクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Controller
public class ProductsController {
    @Autowired
    private ProductsService prodService;

    @ModelAttribute("form")
    public ProductForm setUpForm() {
        return new ProductForm();
    }

    @GetMapping("/products")
    public String getProducts() {
        return "products";
    }

    @PostMapping("/products/showOne")
    public String showOne(@ModelAttribute ProductForm prodForm, BindingResult bindingResult, Model model) {
        // TODO IDとPriceのNull空文字対策
        if(bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
        }

        ResultDTO<Product> dto = prodService.showOne(prodForm);
        model.addAttribute("result", dto.getList());

        return "products";
    }
}