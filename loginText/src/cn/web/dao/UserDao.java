package cn.web.dao;

import cn.web.domain.User;
import cn.web.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表中的类
 */
public class UserDao {


    //声明JDBCTemplate对象共用
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    /**
     * 登陆方法
     * @param loginUser 只有用户名和密码
     * @return User包含所有用户数据
     */
    public static User login (User loginUser){

        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";

            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());


            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }

    }


}
