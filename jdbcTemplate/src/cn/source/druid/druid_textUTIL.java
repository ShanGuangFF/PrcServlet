package cn.source.druid;

import cn.source.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class druid_textUTIL {
    public static void main(String[] args) {
        /**
         * 完成添加操作
         *
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取连接
            conn = JDBCutil.getConnection();
            //2.定义sql
            String sql ="insert into account value(null,?,?)";
            //3.获取pstmt对象
            pstmt = conn.prepareStatement(sql);
            //4.给占位符赋值
            pstmt.setString(1,"李姜丰");
            pstmt.setDouble(2,5000);
            //5.执行sql
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JDBCutil.close(pstmt,conn);
        }

    }
}
