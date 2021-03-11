package loginTest;

import dao.UserDao;
import domain.User;
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
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String checkCode_session =(String) session.getAttribute("checkCode_session");
        //销毁验证码
        session.removeAttribute("checkCode_session");
        //3.先判断验证码
        if(checkCode_session!=null && checkCode_session.equalsIgnoreCase(checkCode)){
            //销毁验证码
            session.removeAttribute("checkCode_session");
            //忽略大小写
            //验证码正确
            //判断用户名和密码是否一致
            User user = UserDao.login(loginUser);
            if(user != null){
                //登陆成功
                //存储用户信息
                session.setAttribute("user",user);
                //重定向到success.jsp页面
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{
                //用户名或密码错误
                //存储信息到request
                request.setAttribute("userError","用户名或密码错误");
                //转发到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            //验证码错误
            //存储信息到request
            request.setAttribute("checkCodeError","验证码错误");
            //转发到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
