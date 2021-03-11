package cn.source.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 定义druid工具类
 *
 */
public class JDBCutil {
    //定义成员变量 DateSource
    private static DataSource ds;

    static {
        //加载配置文件进内存
        Properties properties = new Properties();
        try {
            properties.load(JDBCutil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        获取连接对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /*
        释放资源
     */
    public static void close(Statement statement,Connection connection){
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

    public static void close(ResultSet resultSet,Statement statement, Connection connection){

        if(resultSet !=null){
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

    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }

}
