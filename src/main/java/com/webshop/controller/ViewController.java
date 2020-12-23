package com.webshop.controller;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;
import com.webshop.entity.Product;
import com.webshop.entity.UserInfo;
import com.webshop.form.ProductForm;
import com.webshop.service.CustomerService;
import com.webshop.service.ProductsService;

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
public class ViewController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello");
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {

        model.addAttribute("getInfo", new UserInfo());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("getInfo") UserInfo ui) {
        return "redirect:/login";
    }
}