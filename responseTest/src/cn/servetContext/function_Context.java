package cn.servetContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/function")
public class function_Context extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
            ServletContext（代表整个Web应用，可以和程序的（容器服务器）来通信）功能
            1.获取MIME类型
              MIME类型：在互联网通信过程中定义的一种文件数据类型
                    格式：大类型/小类型 text/html image/jepg
              获取：String getMimeType（String file）
            2.域对象：共享数据,所有用户请求的数据
            3.获取文件真实（服务器）的路径
         */
        ServletContext context = this.getServletContext();
        String filename = "a.jpg";
        System.out.println(context.getMimeType(filename));

        String b = context.getRealPath("/b.txt");//web目录下
        System.out.println(b);
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF目录下
        System.out.println(c);
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//WEB-INF下的classes目录下
        System.out.println(a);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
