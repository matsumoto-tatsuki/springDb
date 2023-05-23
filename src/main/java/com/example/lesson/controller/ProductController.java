package com.example.lesson.controller;

import com.example.lesson.LessonApplication;
import com.example.lesson.entity.ProductRecord;
import com.example.lesson.form.ProductForm;
import com.example.lesson.service.PgProductService;
import com.example.lesson.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/product-list")
    public String productList(Model model) {
        var list = productService.findAll();

        model.addAttribute("products", list);

        return "/product-list";
    }

    @GetMapping("/product/{id}")
    public String productFindById(Model model,@PathVariable("id") int id) {
        var productRecord = productService.findById(id);

        model.addAttribute("product", productRecord);

        return "product";
    }

    @GetMapping("/product-add")
    public String index(@ModelAttribute("productForm") ProductForm productForm) {
        return "product-add";
    }

    @PostMapping("/product-add")
    public String productAdd(Model model, @Validated @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult, HttpServletRequest request) {
        // バリデーション
        if(bindingResult.hasErrors()) {
            return "/product-add";
        }
        System.out.println(productForm);
        var rowNum = productService.allDataNum();
        var num = productService.insert(new ProductRecord(rowNum,productForm.getName(),Integer.parseInt(productForm.getPrice())));
        System.out.println(rowNum);
        return "redirect:/product-list";
    }


    @GetMapping("/product/update/{id}")
    public String updateIndex(Model model,@PathVariable("id") int id, @ModelAttribute("productForm") ProductForm productForm) {
        model.addAttribute("productId", id);
        System.out.println(id);
        return "product-update";
    }

    @PostMapping("/product/update/{id}")
    public String productUpdate(@Validated @ModelAttribute("productForm") ProductForm productForm, BindingResult bindingResult,Model model,@PathVariable("id") int id) {
        // バリデーション
        if(bindingResult.hasErrors()) {
            model.addAttribute("productId", id);
            return "product-update";
        }
        System.out.println(productForm);
        var num = productService.update(new ProductRecord(id,productForm.getName(),Integer.parseInt(productForm.getPrice())));
        System.out.println(new ProductRecord(id,productForm.getName(),Integer.parseInt(productForm.getPrice())));
        return "redirect:/product-list";
    }

    @GetMapping("/product/delete/{id}")
    public String productDelete(Model model,@PathVariable("id") int id) {
        var num = productService.delete(id);
        System.out.println(id);
        return "redirect:/product-list";
    }
}
