package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 *      1.有：不是第一次访问
 *          1.响应数据，欢迎回来，您上次的访问时间为xxx
 *          2.写回cookie：lastTime=xxx
 *      2.无：第一次访问
 *          1.响应数据：您好，欢迎您首次访问
 *          2.写回Cookie：lastTime=xxx
 */
@WebServlet("/cookietest")
public class cookietest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置相应消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取Cookie所有
        Cookie[] cookies = request.getCookies();

        boolean flag = false;//无lastTime Cookie

        //2.遍历Cookie数组找到lastTime
        if(cookies !=null && cookies.length > 0  ){

            for (Cookie cookie : cookies) {
                //3.获取Cookie名称
                String name = cookie.getName();

                //4.判断是否为lastTime
                if("lastTime".equals(name)){

                    flag = true;
                    //不是第一次访问

                    //2.写回cookie：lastTime=xxx
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);

                    //进行编码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    cookie.setValue(str_date);
                    response.addCookie(cookie);

                    //设置Cookie的存活时间
                    cookie.setMaxAge(60*60*24*30);


                    //1.响应数据，欢迎回来，您上次的访问时间为xxx
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次的访问时间为:"+value+"</h1>");

                    break;
                }
            } 
        }

        if(cookies == null || cookies.length == 0 || flag==false ){

            //2.写回Cookie：lastTime=xxx
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            //1.响应数据：您好，欢迎您首次访问
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
