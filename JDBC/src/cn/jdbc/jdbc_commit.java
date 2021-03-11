package cn.jdbc;


import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 */
public class jdbc_commit {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement psta1 = null;
        PreparedStatement psta2 = null;

        try {
            conn = JDBCutil.getConnction();
            //start commit
            conn.setAutoCommit(false);
            String sql1 = "update account set balance = balance - ? where name = ?";
            String sql2 = "update account set balance = balance + ? where name = ?";
            psta1 = conn.prepareStatement(sql1);
            psta2 = conn.prepareStatement(sql2);

            psta1.setDouble(1,500);
            psta1.setString(2,"简十初");
            psta2.setDouble(1,500);
            psta2.setString(2,"简十遇");


            psta1.executeUpdate();

            //手动制造异常
            int a = 3/0;

            psta2.executeUpdate();

            //submit commit

            conn.commit();
        } catch (Exception e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCutil.close(psta1,conn);
            JDBCutil.close(psta2,null);
        }
    }
}
