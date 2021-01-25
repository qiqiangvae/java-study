package org.example.mybatis;

import com.mysql.cj.jdbc.Driver;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.util.*;

/**
 * @author qiqiang
 * @date 2020-11-24 12:56 下午
 */
public class MybatisExample {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Driver driver = Driver.class.newInstance();
        String url = "jdbc:mysql://localhost:3306/chinese_poetry?useUnicode=true&characterEncoding=utf8";
        DataSource dataSource = new SimpleDriverDataSource(driver, url, "root", "mypassword");
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        SqlLogInterceptor sqlLogInterceptor = new SqlLogInterceptor();
        Properties sqlLogInterceptorProperties = new Properties();
        sqlLogInterceptorProperties.setProperty("enable", "true");
        sqlLogInterceptor.setProperties(sqlLogInterceptorProperties);
        configuration.addInterceptor(sqlLogInterceptor);
        configuration.addMapper(ShiMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Map<String, String> map = new HashMap<>(2);
            map.put("author", "李白");
            map.put("title", "静夜思");
            List<ShiEntity> shiList = session.selectList("org.example.mybatis.ShiMapper.selectBy", map);
            System.out.println(Arrays.toString(shiList.toArray()));
        }
    }
}