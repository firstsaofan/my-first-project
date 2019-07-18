package com.itheima.controllers;



import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;


    //查询所有商品
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView fndAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("products",productList);
        mv.setViewName("product-list1");
        /*for (Product product : productList) {
            System.out.println(product);
        }*/
        return mv;
    }

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product){
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";

    }


}
