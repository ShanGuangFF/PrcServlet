package cn.web.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1.强制类型转换
        HttpServletRequest request = (HttpServletRequest) req;

        //2.获取资源请求路径
        String uri = request.getRequestURI();

        //3.判断是否包含登陆相关资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/fonts/") || uri.contains("/js/") || uri.contains("/checkCode")){
            chain.doFilter(req,resp);
        }else{
            //验证用户是否登陆
            Object user = request.getSession().getAttribute("user");

            if(user != null ){
                //已经登陆，放行
                chain.doFilter(req,resp);
            }else{
                //未登录，跳转到登陆页面
                request.setAttribute("msg_login","您未登录，请先登陆");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
