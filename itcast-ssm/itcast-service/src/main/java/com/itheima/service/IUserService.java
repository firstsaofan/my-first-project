package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    //查询所有用户
    List<UserInfo> findAll();

    //添加用户
    void save(UserInfo userInfo);

    // 查询用户详情
    UserInfo findById(String id);


    //给用户添加（关联）角色
    void addRolesToUser(String userId,String[] roleIds);
}
