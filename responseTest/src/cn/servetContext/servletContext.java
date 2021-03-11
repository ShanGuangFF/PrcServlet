package cn.servetContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContext")
public class servletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * ServletContext对象获取
         * 1.通过request对象获取
         *      request.getServletContext();
         * 2.通过HttpServlet获取
         *      this.getServletContext();
         */

        //1.通过request对象获取
        ServletContext servletContext = request.getServletContext();

        //2.通过HttpServlet获取
        ServletContext servletContext1 = this.getServletContext();


        System.out.println(servletContext);
        System.out.println(servletContext1);
        System.out.println(servletContext.equals(servletContext1));//true

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
