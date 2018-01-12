package springoraclesql.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
//@ConfigurationProperties("oracle.dbsource")
public class SqlServiceImpl implements SqlService{

    @Value("${oracle.dbsource.url}")
    private String url;
    @Value("${oracle.dbsource.username}")
    private String username;
    @Value("${oracle.dbsource.password}")
    private String password;

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
