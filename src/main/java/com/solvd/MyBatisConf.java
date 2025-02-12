package com.solvd;

import com.solvd.daos.IClientDAO;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class MyBatisConf {

    public static SqlSessionFactory buildSqlSessionFactory() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        PooledDataSource dataSource
                = new PooledDataSource(resourceBundle.getString("driver"), resourceBundle.getString("url"), resourceBundle.getString("user"), resourceBundle.getString("password"));
        Environment environment
                = new Environment("Development", new JdbcTransactionFactory(), dataSource);

        Configuration configuration = new Configuration(environment);

        configuration.addMapper(IClientDAO.class);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        System.out.println("Interface approach is used");
        return builder.build(configuration);
    }

    public static SqlSessionFactory buildFactoryXml()  {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println("XML approach is used");
        return sqlSessionFactory;
    }
}
