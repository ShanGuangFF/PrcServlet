package cn.source.Template;

import cn.source.util.JDBCutil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 1.修改1号数据的balance
 * 2.添加一条记录
 * 3.删除刚才添加的记录
 * 4.查询id为1的记录，将其封装为Map集合
 * 5.查询所有的记录，将其封装为List
 * 6.查询所有记录，将其封装为emp对象的list集合
 * 7.查询总记录数，聚合函数
 */
public class update {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCutil.getDataSource());
    //使用Junit单元测试，可以让方法独立执行

    @Test
    //1.修改1号数据的balance
    public void up(){
        String sql = "update account set balance = 1000 where id = 1";
        jdbcTemplate.update(sql);
    }

    @Test
    //2.添加一条记录
    public void inset(){
        String sql = "insert into account(name,balance) values(?,?)";
        jdbcTemplate.update(sql,"李姜丰","10000");
    }

    @Test
    //3.删除刚才添加的记录
    public void delete(){
        String sql = "delete from account where name = ?";
        jdbcTemplate.update(sql,"李姜丰");
    }

    @Test
    //4.查询id为1的记录，将其封装为Map集合，结果集只能是一条记录
    public void queMap(){
        String sql = "select * from account where name = '简十遇'";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);
    }

    @Test
    //5.查询所有的记录，将其封装为List
    public void queList(){
        String sql = "select * from account";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    //6.查询所有记录，将其封装为emp对象的list集合
    public void que(){
        String sql = "select * from account";
        List<emp> empList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<emp>(emp.class));
        for (emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    //7.查询总记录数，聚合函数
    public void queObj(){
        String sql = "select count(id) from account";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}
