package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

public interface IOrdersService {


    //查询所有订单
    public List<Orders> findAll(int page,int pageSize);

    //查询订单详情
    public Orders findById(String ordersId) throws Exception;

}
