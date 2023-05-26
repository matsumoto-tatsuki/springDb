package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.form.ProductForm;
import com.example.lesson.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/products")
    public List<ProductRecord> productList(){
        return productService.findAll();
    }

    @GetMapping("/api/products/{id}")
    public ProductRecord productFindById(@PathVariable("id") int id){
        System.out.println("findId");
        return productService.findById(id);
    }

    @PostMapping("/api/product")
    public int productAdd(@ModelAttribute("productForm") ProductForm productForm){
        var rowNum = productService.allDataNum();
        return productService.insert(new ProductRecord(rowNum,productForm.getName(),Integer.parseInt(productForm.getPrice())));
    }

    @PutMapping("/api/product/{id}")
    public int productUpdate(@ModelAttribute("productForm") ProductForm productForm,@PathVariable("id") int id){
        return productService.update(new ProductRecord(id,productForm.getName(),Integer.parseInt(productForm.getPrice())));
    }

    @DeleteMapping ("/api/product/{id}")
    public int productDelete(@PathVariable("id") int id){
        return productService.delete(id);
    }

    @GetMapping("/user")
    public String index() {
        return "user";
    }
}
