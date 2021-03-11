package cn.jdbc;

import demo.emp;
import util.JDBCutil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询语句
 */
public class jdbc_emp_util {

    public static void main(String[] args) {
        System.out.println(findall());
    }

    public static List<emp> findall(){

        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<emp> list = new ArrayList<>();
        try {

            String sql = "select * from account";

            statement = JDBCutil.getConnction().createStatement();
            resultSet = statement.executeQuery(sql);
            emp emp1 = null;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");

                emp1 = new emp(id,name,balance);
                list.add(emp1);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JDBCutil.close(resultSet,statement,connection);

        }

        return list;
    }
}
