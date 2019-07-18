package com.itheima.service.impl;

import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService{
    @Autowired
    private IPermissionDao permissionDao;

    //查询存在的所有权限
    public List<Permission> findAll() {

        List<Permission> permissionList = permissionDao.findAll();
        return permissionList;
    }

    //添加一个权限
    public void save(Permission permission) {
        permissionDao.save(permission);
    }

    //查询出该角色还可以添加的权限
    public List<Permission> findOtherPermission(String id) {
        return permissionDao.findOtherPermission(id);
    }
}
