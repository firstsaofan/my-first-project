package com.itheima.controllers;


import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IRoleService;
import com.itheima.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
        @Autowired
        private IUserService userService;
        @Autowired
        private IRoleService roleService;


        //查询所有用户
        @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;

    }
    //添加用户
    @RequestMapping("/save.do")
   public String save(UserInfo userInfo){
            userService.save(userInfo);
            return "redirect:findAll.do";


   }

   //查询用户详情包含角色 以及角色包含的权限（用户->角色 n->n）(角色->权限 n->n)
    @RequestMapping("findById.do")
    public ModelAndView findById(String id){
        ModelAndView  mv= new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return  mv;
    }


    //查询出所有能给这个用户添加的角色（关联角色）
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id){
            UserInfo user = userService.findById(id);
            List<Role> roleList =roleService.findOtherRole(id);
            ModelAndView mv = new ModelAndView();
            mv.addObject("user",user);
            mv.addObject("roleList",roleList);
            mv.setViewName("user-role-add");
            return mv;

    }

    //给用户关联角色（给user_role表添加数据）
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids",required = true) String[] roleIds){
        userService.addRolesToUser(userId, roleIds);
        return "redirect:findAll.do";

    }


}


