package springoraclesql.demo.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface SqlService {

    Connection getConnection() throws SQLException;

}
