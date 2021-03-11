package cn.source.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class First_druid {
    public static void main(String[] args) throws Exception {

        //加载配置文件进内存
        Properties pro = new Properties();

        InputStream inputStream = First_druid.class.getClassLoader().getResourceAsStream("druid.properties");

        pro.load(inputStream);

        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);

        Connection connection = dataSource.getConnection();

        System.out.println(connection);

    }
}
