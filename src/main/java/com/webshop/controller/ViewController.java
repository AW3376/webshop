package com.webshop.controller;

import com.webshop.entity.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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