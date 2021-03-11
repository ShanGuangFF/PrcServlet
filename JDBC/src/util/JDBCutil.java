package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCutil {

    private static String url;
    private static String user;
    private static String password;
    private static String Driver;

    /*
        使用静态代码块，只需读取一次便可以拿到这些值
     */
    static {
        try {
            //1.创建Properties集合类
            Properties properties = new Properties();

            //获取SRC路径下的文件的方式-->ClassLoader类加载器
            ClassLoader classLoader = JDBCutil.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();

            //2.加载文件进内存
            properties.load(new FileReader(path));

            //3.获取数据，赋值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Driver = properties.getProperty("Driver");

            //4.注册驱动
            Class.forName(Driver);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *注册驱动，获取连接对象
     * @return 连接对象
     */
    public static Connection getConnction() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }


    /**
     * 释放资源
     * @param statement
     * @param connection
     */
    public static void close(Statement statement,Connection connection){
        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet,Statement statement, Connection connection){

        if( resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
