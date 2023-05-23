package com.example.lesson.dao;

import com.example.lesson.entity.ProductRecord;
import org.springframework.jdbc.core.DataClassRowMapper;

import java.util.List;

public interface ProductDao {
     int allDataNum();
     List<ProductRecord> findAll();
     ProductRecord findById(int id);

     int insert(ProductRecord productRecord);
     int update(ProductRecord productRecord);
     int delete(int id);
}
