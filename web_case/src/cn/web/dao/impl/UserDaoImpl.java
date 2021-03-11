package cn.web.dao.impl;

import cn.web.dao.UserDao;
import cn.web.domain.User;
import cn.web.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public  List<User> findAll() {
        //操作数据库
        //1.编写sql
        String sql = "select * from user";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    @Override
    public User login(String username ,String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User loginUser = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return loginUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values (null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from user where id =?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int totalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1 = 1 ";
        Set<String> keySet = condition.keySet();
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        for (String ks : keySet) {

            if("currentPage".equals(ks) || "rows".equals(ks)){
                continue;
            }

            String value = condition.get(ks)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+ks+" like ?");
                params.add("%"+value+"%");
            }
        }

        sql = sb.toString();
        System.out.println(sql);
        return template.queryForObject(sql,Integer.class,params.toArray());
    }


    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        Set<String> keySet = condition.keySet();
        StringBuilder sb = new StringBuilder(sql);
        List params = new ArrayList();
        for (String ks : keySet) {

            if("currentPage".equals(ks) || "rows".equals(ks)){
                continue;
            }

            String value = condition.get(ks)[0];
            if(value != null && !"".equals(value)){
                sb.append(" and "+ks+" like ?");
                params.add("%"+value+"%");
            }
        }

        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(rows);

        sql = sb.toString();

        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
