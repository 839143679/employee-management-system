package com.zjr.Mapper;

import com.zjr.model.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {

    //添加员工完整信息
    //useGeneratedKeys自增列是主键列
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(name,age,sex,phone,dept,salary,joinDate,username,password) values(#{name},#{age},#{sex},#{phone},#{dept},#{salary},#{joinDate},#{username},#{password})")
    int addEmployee(Emp emp);

    //根据id删除员工
    @Delete("delete from emp where id =#{id}")
    int deleteEmployee(@Param("id") Integer id);

    //根据id更新员工信息
    @Update("update emp set name = #{name},age = #{age},sex = #{age},phone = #{phone},dept = #{dept},salary = #{salary},joinDate = #{joinDate} where id = #{id}")
    int updateEmployee(Emp emp);

    //根据username查询信息
    @Select("select id,name,age,sex,phone,dept,salary,joinDate,username,password from emp where username = #{username}")
    Emp queryEmployeeByUsername(@Param("username")String username);

    //根据id查询员工信息
    @Select("select id,name,age,sex,phone,dept,salary,joinDate from emp where id = #{id}")
    Emp queryEmployeeById(@Param("id") Integer id);

    //查询全部员工信息,以map接收

    //查询全部员工信息,以emp类对象接收
    @Select("select id,name,age,sex,phone,dept,salary,joinDate,signin,signtime from emp")
    List<Emp> queryEmployees();

    /*
   根据用户名查询用户信息
   username:用户名
   如果返回是null,说明没有这个用户,反之...
    */
    @Select("select id,username,password from emp where username = #{username}")
    Emp queryUserByUserName(@Param("username") String username);


    /*
    根据用户名和密码查询用户信息
     */
    @Select("select id,username,password from emp where username=#{username} and password = #{password}")
    Emp queryUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    //根据用户名的id查询用户信息(id,姓名)
    @Select("select id,name from emp where id = #{id}")
    Emp queryIdAndNameById(@Param("id") Integer id);

    /*
    保存一条用户信息到数据库
    返回-1表示操作失败,返回其他受影响的行数
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username,password) value(#{username},#{password})")
    int saveUser(@Param("username") String username, @Param("password") String password);

    //根据id查询用户名和密码
    @Select("select username,password from emp where id = #{id}")
    Emp queryUserById(@Param("id") Integer id);


   //修改密码
    @Update("update emp set password = #{password} where username = #{username}")
    int updatePassword(Emp emp);

    @Update("update emp set signin = #{signIn} ,signtime = #{signTime} where id = #{id}")
    int updateSignIn(Emp employee);//签到,修改签到和签到时间

    @Select("select id,name,age,sex,phone,dept,salary,joinDate,signin,signtime from emp where id = #{id}")
    Emp querySign(@Param("id") Integer id);

    @Update("update emp set signin = null,signtime = null")
    int updateSignInAll();//重置签到表的时间和签到
}
