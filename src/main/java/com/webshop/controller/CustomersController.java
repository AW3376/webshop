package com.webshop.controller;

import com.webshop.dto.ResultDTO;
import com.webshop.entity.Customer;
import com.webshop.form.CustomerForm;
import com.webshop.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// コントローラクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Controller
@RequestMapping("customers")
public class CustomersController {
    @Autowired
    private CustomerService custService;

    @ModelAttribute("form")
    public CustomerForm setUpForm() {
        return new CustomerForm();
    }

    @GetMapping("")
    public String customersTopPage() {
        return "customers";
    }

    @PostMapping(value = "execute", params = "showAllCustomer")
    public String showAllCustomer(Model model) {
        // execute service
        ResultDTO<Customer> dto = custService.selectAll();

        // set result
        model.addAttribute("list", dto.getList());

        return "customers";
    }

    @PostMapping(value = "execute", params = "searchCutomer")
    public String searchCutomer(Model model) {
        // execute service
        ResultDTO<Customer> dto = custService.selectAll();

        // set result
        model.addAttribute("list", dto.getList());

        return "customers";
    }

    @PostMapping(value = "execute", params = "addCustomer")
    public String addCustomer(Model model) {
        return "customers";
    }

    @PostMapping(value = "execute", params = "editCustomer")
    public String editCustomer(Model model) {
        return "customers";
    }

    @PostMapping(value = "execute", params = "deleteCustomer")
    public String deleteCustomer(Model model) {
        return "customers";
    }
}