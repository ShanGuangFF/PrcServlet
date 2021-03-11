package cn.jdbc;

import demo.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询语句
 */
public class jdbc_emp {

    public static void main(String[] args) {
        System.out.println(findall());
    }

    public static List<emp> findall(){

        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<emp> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from account";
            connection = DriverManager.getConnection("jdbc:mysql://localhost/stu","root","ljfwww666");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            emp emp1 = null;
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");

                emp1 = new emp(id,name,balance);
                list.add(emp1);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

        return list;
    }
}
