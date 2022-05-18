package com.zjr.Utils;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void  setCookie(String key, String value,HttpServletResponse response){
        Cookie cookie = new Cookie(key,value);
        //设置cookie过期时间
        cookie.setMaxAge(1 * 24 * 60 * 60);//1天过期
        //表示当前项目下都携带这个cookie
        cookie.setPath("/");
        //将cookie对象加入response响应
        response.addCookie(cookie);
    }
}
