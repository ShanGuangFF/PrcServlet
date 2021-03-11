package cn.web;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/servletDemo")
public class responseTest extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*//1.设置状态码
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/responseTest_war_exploded/servletDemo1");
        */
        response.sendRedirect("/servletDemo1");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
