package com.zjr.Controller;

import com.zjr.Mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    EmpMapper empMapper;

    //打开8080自动跳转到首页
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/toEmpMain",method = RequestMethod.POST)
    public String toEmpMain(@CookieValue(value = "loginId", defaultValue = "nullCookie") String idString, Map<String,Object> map){
        System.out.println(idString);
        Integer id = Integer.valueOf(idString);
        return "/manager/empManager";
    }
    @RequestMapping(value = "/toMain",method = RequestMethod.POST)
    public String toMain(@CookieValue(value = "loginId", defaultValue = "nullCookie") String idString, Map<String,Object> map){
        System.out.println(idString);
        Integer id = Integer.valueOf(idString);
        return "/manager/manager";
    }
}
