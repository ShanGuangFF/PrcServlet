package cn.web.web.servlet;

import cn.web.dao.UserDao;
import cn.web.dao.impl.UserDaoImpl;
import cn.web.domain.User;
import com.mysql.cj.Session;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数Map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2.获取用户验证码
        String verifycode = request.getParameter("verifycode");
        HttpSession session = request.getSession();
        User loginUser = new User();
        String checkcode_server =(String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.先判断验证码是否正确
        if(checkcode_server != null && checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码正确


            UserDao dao = new UserDaoImpl();
            User user = dao.login(loginUser.getUsername(), loginUser.getPassword());
            if(user != null){
                //用户名密码正确
                //存储用户信息，重定向到登陆页面
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }else {
                request.setAttribute("msg_login","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //验证码错误
            request.setAttribute("msg_login","验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
