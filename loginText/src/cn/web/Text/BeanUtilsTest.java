package cn.web.Text;

import cn.web.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public class BeanUtilsTest {


    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username",1231);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(user.getUsername().equals(1231));
        System.out.println(user);
    }
}
