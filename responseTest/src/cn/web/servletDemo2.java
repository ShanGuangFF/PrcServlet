package cn.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletDemo2")
public class servletDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流对象之前，设置流默认的编码：ISO-8859-1 设置为：GBK
        //resp.setCharacterEncoding("utf-8");

        //告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
        //resp.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式设置编码
        resp.setContentType("text/html;charset=utf-8");

        //1.获取字符输入流
        PrintWriter pw = resp.getWriter();
        //2.输出数据
        pw.write("hhahahh啊哈哈哈");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
