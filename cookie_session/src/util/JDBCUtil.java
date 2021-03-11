package util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Druid连接池
 */
public class JDBCUtil {
    private static DataSource dataSource;
    //初始化连接池
    static {

        try {
            //加载配置文件进内存
            Properties pro = new Properties();

            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            //初始化连接池
            dataSource = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取Connection对象
     */

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
