package utilsTest;

import dao.UserDao;
import domain.User;
import org.junit.jupiter.api.Test;

public class test {


    @Test
    public void test(){
        User loginUser = new User();
        loginUser.setUsername("简十初");
        loginUser.setPassword("ljfwww666");
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        System.out.println(user);
    }



}
