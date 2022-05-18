package com.zjr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String name;
    private  Integer age;
    private String sex;
    private  String phone;
    private  String dept;//部门名字
    private BigDecimal salary;//工资
    private String joinDate;
    private String signIn;
    private String signTime;//签到时间
    private  String username;
    private String password;
}
