package com.example.lesson.controller;

import com.example.lesson.LessonApplication;
import com.example.lesson.service.PgProductService;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("product-list")
    public String productList(Model model) {
        var list = productService.findAll();

        model.addAttribute("products", list);

        return "product-list";
    }

    @GetMapping("product/{id}")
    public String productFindById(Model model,@PathVariable("id") int id) {
        var productRecord = productService.findById(id);

        model.addAttribute("product", productRecord);

        return "product";
    }
}
