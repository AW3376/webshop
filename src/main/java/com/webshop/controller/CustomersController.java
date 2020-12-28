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
import org.springframework.validation.BindingResult;

// コントローラクラスに付与するもの。Springのコンポーネントと認識され
// ApplicationContextに登録されてDI対象のクラスとなる
@Controller
@RequestMapping("customers")
public class CustomersController {
    @Autowired
    private CustomerService custService;

    @ModelAttribute("custForm")
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
    public String searchCutomer(@ModelAttribute CustomerForm custForm, BindingResult bs, Model model) {
        if(bs.hasErrors()) { return "customers"; }
        // execute service
        ResultDTO<Customer> dto = custService.selectCustomers(custForm);
        model.addAttribute("list", dto.getList());

        return "customers";
    }

    @PostMapping(value = "execute", params = "addCustomer")
    public String addCustomer(@ModelAttribute CustomerForm custForm, BindingResult bs, Model model) {
        if(bs.hasErrors()) { return "customers"; }
        // execute service
        custService.insertCustomer(custForm);

        return "customers";
    }

    @PostMapping(value = "execute", params = "setCustomerForm")
    public String setCustomerForm(@ModelAttribute CustomerForm custForm, BindingResult bs, Model model) {
        if(bs.hasErrors()) { return "customers"; }

        model.addAttribute("custForm", custForm);

        return "customers";
    }

    @PostMapping(value = "execute", params = "editCustomer")
    public String editCustomer(@ModelAttribute CustomerForm custForm, BindingResult bs, Model model) {
        if(bs.hasErrors()) { return "customers"; }

        // execute service
        custService.updateCustomer(custForm);

        return "customers";
    }

    @PostMapping(value = "execute", params = "deleteCustomer")
    public String deleteCustomer(@ModelAttribute CustomerForm custForm, BindingResult bs, Model model) {
        if(bs.hasErrors()) { return "customers"; }
        // 誤操作防止のためにコメントアウトしときましょ
        // execute service
        // custService.deleteCustomer(custForm);

        return "customers";
    }
}