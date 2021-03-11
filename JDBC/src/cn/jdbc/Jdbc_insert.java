package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * insert一条语句
 */
public class Jdbc_insert {
    public static void main(String[] args) {
        Connection conn = null;
        Statement sate = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values(null,'简十初',1800)";
            //3.获取connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","ljfwww666");
            //4.获取执行sql的statement对象
            sate = conn.createStatement();
            //5.执行sql
            int i = sate.executeUpdate(sql);
            //6.处理结果
            System.out.println(i);
            //7.判断结果
            if(i > 0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            //避免空指针异常
            if(sate != null){
                try {
                    sate.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
