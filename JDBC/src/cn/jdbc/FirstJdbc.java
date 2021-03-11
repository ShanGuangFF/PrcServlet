package cn.jdbc;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * jdbc快速入门
 */
public class FirstJdbc {
    public static void main(String[] args) throws Exception {
        //导入驱动jar包
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取连接对象
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu", "root", "ljfwww666");
        //定义sql语句
        String sql = "update student3 set math = 100 where id = 1";
        //获取执行sql的对象 Statement
        Statement statement = root.createStatement();
        //执行sql
        int count =statement.executeUpdate(sql);
        //处理结果
        System.out.println(count);
        //释放资源
        statement.close();
        root.close();
    }
}
