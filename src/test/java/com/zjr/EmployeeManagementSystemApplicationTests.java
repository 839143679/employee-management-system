package com.zjr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

    @Test
    void contextLoads() {

    }
    @Test
    public void  dateTime1(){
        //156ms
        long start1 = System.currentTimeMillis();
        java.util.Date day=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(day));
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) + "ms");//0ms
    }
    @Test
    public void  dateTime2(){
        //3ms
        long start1 = System.currentTimeMillis();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis()));
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) + "ms");//0ms
    }
    @Test
    public void  dateTime3(){
        //2ms
        long start1 = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateString = sdf.format(date);
        System.out.println(dateString);
        long end1 = System.currentTimeMillis();
        System.out.println((end1 - start1) + "ms");//0ms
    }

}
