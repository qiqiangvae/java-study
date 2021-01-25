package org.example.mybatis.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.example.mybatis.ShiEntity;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qiqiang
 * @date 2020-12-17 14:16
 */
public class JdbcExample {
    public static void main(String[] args) throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/chinese_poetry";
        String username = "root";
        String password = "mypassword";
        DataSource dataSource = new SimpleDriverDataSource(driver, url, username, password);
        Connection connection = dataSource.getConnection();
        String sql = "select * from chinese_poetry_shi where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, 131L);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            ShiEntity shiEntity = new ShiEntity();
            Long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            shiEntity.setId(id);
            shiEntity.setAuthor(author);
            shiEntity.setTitle(title);
            System.out.println(shiEntity);
        }
    }
}