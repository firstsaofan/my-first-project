package com.itheima.service.impl;

import com.itheima.dao.IPermissionDao;
import com.itheima.dao.IRoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;


    //查询所有角色
    public List<Role> findAll() {
      List<Role> roleList= roleDao.findAll();
        return roleList;
    }

    //添加角色
    public void save(Role role) {
        roleDao.save(role);
    }

    public List<Role> findOtherRole(String id) {
        return roleDao.findOtherRole(id);
    }

    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    //根据Id查询角色
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
