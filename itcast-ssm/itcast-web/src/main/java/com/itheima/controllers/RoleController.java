package com.itheima.controllers;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.IPermissionService;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    //根据查询所有的角色返回到页面上
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;

    }

    //角色添加
    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";

    }

/*    //查询出所有能给这个角色添加的权限（关联权限）
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId){
        Role role = roleService.findById(roleId);
        List<Permission> permissionList =permissionService.findOtherPermission(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role",role);
        System.out.println(role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;

    }*/
//根据roleId查询role，并查询出可以添加的权限
@RequestMapping("/findRoleByIdAndAllPermission.do")
public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) {
    ModelAndView mv = new ModelAndView();
    //根据roleId查询role
    Role role = roleService.findById(roleId);
    //根据roleId查询可以添加的权限
    List<Permission> otherPermissions = roleService.findOtherPermission(roleId);
    mv.addObject("role", role);
    mv.addObject("permissionList", otherPermissions);
    mv.setViewName("role-permission-add");
    return mv;

}
    //给用户关联角色（给role_permission表添加数据）
  /*  @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId, @RequestParam(name = "permissionIds",required = true) String[] permissionIds){
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";

    }*/
    //给用户关联角色（给role_permission表添加数据）
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId, @RequestParam(name = "ids", required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }

}
