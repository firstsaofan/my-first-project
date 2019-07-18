package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface IPermissionService {

    //查询所有权限
    List<Permission> findAll();

    //添加一个权限
    void save(Permission permission);

    //查询出该角色还能添加的权限
    List<Permission> findOtherPermission(String id);
}
