package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface IRoleService {

    //查询所有的角色
    public List<Role> findAll();

    //添加角色
    void save(Role role);

    //根据id 查询用户可以添加的角色（即是排除自己已经含有的角色）
    List<Role> findOtherRole(String id);

    //根据id 查询角色可以添加的权限（即是排除自己已经含有的权限）
    List<Permission> findOtherPermission(String id);

    //根据Id 查询角色
    Role findById(String id);
    //给角色添加权限
    void addPermissionToRole(String roleId,String[] permissionIds);
}
