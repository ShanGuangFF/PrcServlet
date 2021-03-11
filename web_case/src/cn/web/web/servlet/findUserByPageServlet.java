package cn.web.web.servlet;

import cn.web.domain.PageBean;
import cn.web.domain.User;
import cn.web.service.UserService;
import cn.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //1.接受请求参数，当前页码和每页显示条数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "7";
        }

        Map<String, String[]> condition = request.getParameterMap();


        //2.调用Service查询PageBean
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows),condition);

        //3.将PageBean存入request
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);

        //4.转发list.jsp展示
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
