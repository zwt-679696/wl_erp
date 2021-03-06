package com.weiling.wl_erp.controller;

import com.weiling.wl_erp.bean.User;
import com.weiling.wl_erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 作者：王怀朋
 * 日期：2019/6/10
 * 用户校验类
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
    *作者：王怀朋
    *参数：username,password
    *功能：校验用户名与密码
    */
    @RequestMapping(value = "/checkNamePass",method = RequestMethod.POST)
    @ResponseBody
    public int checkNamePass(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1=userService.checkNamePass(user);
        if(user1!=null){
            if(user1.getZhuangtai()==1){
                    user1.setZhuangtai(2);
            }else{
                user1.setZhuangtai(1);
            }
            userService.changeZhuangtai(user1);
            session.setAttribute("username",user1);
            return 1;
        }
        return 0;
    }
    /*查询登陆人验证权限*/
    @RequestMapping("/checkqx")
    @ResponseBody
    public User checkqx(HttpSession session){
        User user = (User)session.getAttribute("username");
        return user;
    }

    @RequestMapping(value="/ceshi")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAllUser();
    }

    /*修改密码*/
    @RequestMapping(value="/changePass")
    @ResponseBody
    public int changePass(HttpServletRequest request,HttpSession session){
        String password = request.getParameter("password");
        User user = (User)session.getAttribute("username");
        user.setPassword(password);
        return userService.changePass(user);
    }
    @RequestMapping("/checkZhuangTai")
    @ResponseBody
    public int checkZhuangTai(HttpSession session){
        User user = (User)session.getAttribute("username");
        if(user==null){
            return 3;
        }
        User uu = userService.findUserById(user.getId());
        if(uu.getZhuangtai()==user.getZhuangtai()){
            return 1;
        }
        return 0;
    }

}
