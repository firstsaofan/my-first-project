package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    //根据用户Id 查出roleId 在根据roleId 查出所有权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(String id);

    //查询存在的所有权限
    @Select("select * from permission")
    List<Permission> findAll();

    //添加一个新的权限
    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    //查询出该角色还可以添加的权限
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findOtherPermission(String id);
}
