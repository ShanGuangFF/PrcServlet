package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
   update语句
 */
public class jdbc_update {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update account set balance = 1500 where id = 1";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/stu","root","ljfwww666");
            stat = conn.createStatement();
            int i = stat.executeUpdate(sql);
            if(i>0)
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(stat != null){
                try {
                    stat.close();
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
