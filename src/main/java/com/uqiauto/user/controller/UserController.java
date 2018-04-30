package com.uqiauto.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uqiauto.user.model.User;
import com.uqiauto.user.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/uplus")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/user/all")
    public Map<String,Object> findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        Map<String,Object> result=new HashMap<>();
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<User> userPageInfo= userService.findAllUser(pageNum,pageSize);
        result.put("total",userPageInfo.getTotal());
        result.put("rows",userPageInfo.getList());
        result.put("pages",userPageInfo.getPages());
        return result;
    }
}
