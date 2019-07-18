package com.itheima.service.impl;

import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired

    private IProductDao iProductDao;


    public List<Product> findAll() {

        return iProductDao.findAll();
    }

    public void save(Product product) {
               iProductDao.save(product);
    }

    public Product findById(String id) {
        return null;
    }
}
