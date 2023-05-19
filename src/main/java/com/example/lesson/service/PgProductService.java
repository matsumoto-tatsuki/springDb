package com.example.lesson.service;

import com.example.lesson.dao.ProductDao;
import com.example.lesson.entity.ProductRecord;
import com.example.lesson.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PgProductService implements ProductService{

    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll(){
        return productDao.findAll();
    }
    @Override
    public ProductRecord findById(int id) {
        var productRecord = productDao.findById(id);
        if(productRecord == null){
            throw new ProductNotFoundException();
        }
        return productRecord;
    }

    @Override
    public int insert(ProductRecord productRecord) {
        try{
            return productDao.insert(productRecord);
        }catch (RuntimeException e){
            throw new ProductNotFoundException();
        }
    }

    @Override
    public int update(ProductRecord productRecord) {
        return productDao.update(productRecord);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }
}
