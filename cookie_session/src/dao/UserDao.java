package dao;


import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtil;


public class UserDao {

    //声明jdbcTemplate共用
    public static JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtil.getDataSource());


    /**
     * 登陆方法
     *
     * @param loginUser 只包含用户名和密码
     * @return 包含用户所有的数据
     */
    public static User login(User loginUser) {

        try {
            //编写sql语句
            String sql = "select * from user where username = ? and password = ?";

            //调用查询语句，封装对象
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
