package org.dfzr.controller;

import org.dfzr.pojo.UserInfo;
import org.dfzr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@RequestMapping(path = "/user")
@Controller
public class UserInfoController {

    @Autowired
    IUserService service ;

    //用户登录
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(UserInfo user){
        boolean isLogin = service.login(user);
        if(isLogin){
            return "forward:/product/findPage";
        }else {
            return "redirect:/login.html";
        }
    }

    //转发到注册界面
    @RequestMapping(path = "/forwardRegister")
    public String forwardRegister(){
        return "register";
    }

    //用户注册，用户名是否重复校验
    @RequestMapping(path = "/registerCheck")
    public @ResponseBody UserInfo registerCheck(@RequestBody UserInfo user) throws IOException {
        UserInfo userInfo = service.registerCheck(user);
        return userInfo;
    }


    //用户注册
    @RequestMapping(path = "/register",method = RequestMethod.POST)
    public String register(UserInfo userInfo){
        service.register(userInfo);
        return "redirect:/login.html";
    }
}
