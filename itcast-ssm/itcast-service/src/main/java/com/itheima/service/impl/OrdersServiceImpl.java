package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;
    //完成分页操作
    public List<Orders> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAll();
    }

    public Orders findById(String ordersId) throws Exception {


        return ordersDao.findById(ordersId);
    }


}
