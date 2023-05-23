package com.example.lesson.service;

import com.example.lesson.entity.ProductRecord;

import java.util.List;

public interface ProductService {
    int allDataNum();
    List<ProductRecord> findAll();
    ProductRecord findById(int id);
    int insert(ProductRecord productRecord);
    int update(ProductRecord productRecord);
    int delete(int id);
}
