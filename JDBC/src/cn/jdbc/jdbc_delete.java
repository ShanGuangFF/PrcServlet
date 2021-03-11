package cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_delete {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stae1 = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from account where id = 1";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/stu","root","ljfwww666");
            stae1 = conn.createStatement();
            int i = stae1.executeUpdate(sql);
            System.out.println(i);
            if(i > 0)
                System.out.println("删除成功");
            else
                System.out.println("删除失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(stae1 != null){
                try {
                    stae1.close();
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
