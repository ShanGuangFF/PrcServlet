package cn.web.Text;

import cn.web.dao.UserDao;
import cn.web.domain.User;
import org.junit.jupiter.api.Test;

public class UserDaoTest {


    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("zhangsan");
        loginUser.setPassword("123");


        UserDao dao = new UserDao();
        User user = dao.login(loginUser);


        System.out.println(user);
    }
}
