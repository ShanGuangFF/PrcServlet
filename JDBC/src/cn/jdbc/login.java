package cn.jdbc;


import util.JDBCutil;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * 练习：
 *      *需求
 *      1.判断键盘录入用户名和密码
 *      2.判断用户是否登陆成功
 *
 *
 *      *产生问题：
 *      SQL注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接，会造成安全性问题
 *      解决：使用PreparedStatement-->动态sql，预编译sql
 *      编译的sql使用？占位符
 *      后期给？赋值
 * @author cc_FF
 */
public class login {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = input.nextLine();

        System.out.println("请输入密码");
        String password = input.nextLine();

        boolean flag = log(username,password);

        if(flag){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }


    public static boolean log(String username, String password){
        if(username == null || password == null)
            return false;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCutil.getConnction();
            String sql = "select * from user where username= ? and password= ? ";
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(resultSet,statement,connection);
        }


        return false;
    }
}
