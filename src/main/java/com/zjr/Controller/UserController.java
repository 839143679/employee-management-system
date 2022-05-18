package com.zjr.Controller;

import com.zjr.Mapper.EmpMapper;
import com.zjr.Utils.CookieUtil;
import com.zjr.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


//首页登陆注册相关
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    EmpMapper empMapper;

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    /*@GetMapping(value = "/login")*/
    public String login(Map<String,Object> map, HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        Emp emp = empMapper.queryUserByUsernameAndPassword(username,password);//id,username,password
        if (emp ==null){
            System.out.println("登陆失败,用户名/密码错误");
            return "/index";
        }else {
            Emp emp1 = empMapper.queryEmployeeByUsername(username);//all
            System.out.println(emp1.getId());
            map.put("loginEmp",emp1);
            //之后每次跳转页面都要传递一个id,太麻烦了,创建一个cookie
            Integer id = emp1.getId();
           String idString = String.valueOf(id);
           /* //创建一个cookie保存登陆者的id
            Cookie cookie = new Cookie("loginId",idString);
            //设置cookie过期时间
            cookie.setMaxAge(1 * 24 * 60 * 60);//1天过期
            //表示当前项目下都携带这个cookie
            cookie.setPath("/");
            //将cookie对象加入response响应
            response.addCookie(cookie);*/
            CookieUtil.setCookie("loginId",idString,response);
            CookieUtil.setCookie("loginName",emp1.getName(),response);
            //return "/user/login_success";
            //return"/manager/manager";
            if (username.equals("admin")) {
                return "/manager/manager";
            }else {
                return"/manager/empManager";
            }
        }
    }

    //跳转注册页面
    @RequestMapping("/add")
    public String add(){
        return "/user/register";
    }
   //注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, Model m){
        String username = request.getParameter("username");
        if (empMapper.queryUserByUserName(username)==null){
            String password = request.getParameter("password");
            empMapper.saveUser(username,password);
            return "/user/register_success";
        }else{
            System.out.println("用户名:"+username+"已存在");
            String reason = "用户名" + username + "已存在";
            m.addAttribute("reason",reason);
            return "/user/register_failed";

        }
    }
    //跳转修改密码页面
    @RequestMapping(value = "/toUpdatePwd",method = RequestMethod.POST)
    public String toUpdatePwd(@CookieValue(value = "loginId", defaultValue = "nullCookie") String idString,Map<String,Object> map){
        Integer id = Integer.valueOf(idString);
        Emp emp = empMapper.queryUserById(id);
        //System.out.println(emp);
        map.put("updateEmp",emp);
        return "/user/update";
    }

    //修改密码
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public  String updateUser(Emp emp){
       // System.out.println(emp);
        //System.out.println(id);
        System.out.println(emp);
        empMapper.updatePassword(emp);
        return "/user/update_success";
    }

    //返回首页
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "index";
    }


    //注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response,String id){
        Cookie idCookie  = new Cookie("loginId","");
        Cookie nameCookie  = new Cookie("loginName","");
        idCookie.setMaxAge(0);
        nameCookie.setMaxAge(0);
        idCookie.setPath("/");
        nameCookie.setPath("/");
        response.addCookie(idCookie);
        response.addCookie(nameCookie);
        return "index";
    }

}
