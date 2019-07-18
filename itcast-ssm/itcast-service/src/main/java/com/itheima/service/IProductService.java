package com.itheima.service;

import com.itheima.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {

    //查询所有的商品信息
    public List<Product> findAll();

    //增加商品信息
    void save(Product product);

    //根据Id查询商品信息
    public  Product findById(String id);

}
