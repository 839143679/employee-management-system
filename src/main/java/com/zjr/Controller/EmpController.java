package com.zjr.Controller;

import com.sun.org.apache.regexp.internal.RE;
import com.zjr.Mapper.EmpMapper;
import com.zjr.model.Emp;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


@RequestMapping("/emp")
@Controller
public class EmpController {

    @Autowired
    EmpMapper empMapper;

   /* @RequestMapping(value = "/toSign" , method = RequestMethod.POST)
    public String toSign(@RequestParam("id") Integer id, HttpServletRequest request){
        //String uid = request.getParameter("id");
        //System.out.println(uid);
        System.out.println(id);
        //System.out.println(uid);
        return "/sign/sign";
    }*/

   //签到
    @RequestMapping(value = "/sign" , method = RequestMethod.POST)
    public String sign(@CookieValue(value = "loginId", defaultValue = "nullCookie") String idString, Map<String, Object> map){
        System.out.println("获取的id是:" + idString);
        Integer id = Integer.valueOf(idString);
        Emp emp = empMapper.querySign(id);
        System.out.println("是否签到:" + emp.getSignIn());
        if (emp.getSignIn()==null){
            //设置日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //当前系统时间(当前系统时间和GMT时间(格林威尔时间)1970年1月1日0时0分0秒所差的毫秒数)
            String signTime = sdf.format(System.currentTimeMillis());
            System.out.println(signTime);
            String signIn = "true";
            Emp newEmp = new Emp(id, null, null, null, null, null, null, null, signIn, signTime, null, null);
            System.out.println(newEmp.getId());
            map.put("emp",newEmp);
            empMapper.updateSignIn(newEmp);
            return "/sign/sign_success";
        }else {
            System.out.println("重复签到");
            map.put("emp",emp);
            return "/sign/sign_again";
        }

    }


    //查看全部员工信息
    @RequestMapping(value = "/queryAllEmps" , method = RequestMethod.POST)
    public String queryAllEmps(Map<String,Object> map){
        List<Emp> empList=empMapper.queryEmployees();
        map.put("emps",empList);
        return "/emp/emps";
    }

    //重置签到信息
    @RequestMapping(value = "/resetSign", method = RequestMethod.POST)
    public String  resetSign(){
        int i = empMapper.updateSignInAll();
        System.out.println("重置了" + i + "名员工的签到信息");

        //response.sendRedirect("/emp/emps");
        return "redirect:/emp/emps";
    }
    //跳转修改员工信息
    @RequestMapping("/toEmpUpdate")
    public String toEmpUpdate(@RequestParam(value = "id")Integer id,Map<String,Object> map){
        System.out.println("传递过来的id是:" + id);
        Emp emp = empMapper.queryEmployeeById(id);
        map.put("updateEmp",emp);
        return "/emp/update";
    }

    //修改员工信息
    @RequestMapping("/empUpdate")
    public String EmpUpdate(Emp emp){
        System.out.println("传递过来的emp是:" + emp);
        int i = empMapper.updateEmployee(emp);
        return "/emp/update_success";
    }
    //跳转添加员工页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/emp/add";
    }

    //删除员工信息
    @RequestMapping("/delete")
    public String deleteAction(@RequestParam(value = "id") Integer id){
        System.out.println("传递过来的id是:" + id);
        int i = empMapper.deleteEmployee(id);
        return "redirect:/emp/emps";

    }


    //修改员工信息后重定向的跳转
    @RequestMapping("/emps")
    public String emps(Map<String,Object> map){
        List<Emp> empList=empMapper.queryEmployees();
        map.put("emps",empList);
        return "/emp/emps";
    }


}
