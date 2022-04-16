package db;

import utils.resources.IReadProperty;
import utils.resources.ReadPropertiesFromPropsFile;

import java.sql.*;
import java.util.Properties;

public class MySqlDbExecutor implements IDbExecutor {

    private static Connection connect = null;
    private static Statement statement = null;
    private IReadProperty<Properties> readerProps;
    private Properties properties;

    public MySqlDbExecutor() {
        readerProps = new ReadPropertiesFromPropsFile();
        properties = readerProps.read();
    }

    @Override
    public ResultSet execute(String sqlRequest) {
        ResultSet resultSet = null;
        try {
            connect = DriverManager.getConnection(
                    properties.getProperty("url") + "/" + properties.getProperty("db_name"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlRequest);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public int executeUpdate(String sqlUpdate) {
        int rows = 0;
        try {
            connect = DriverManager.getConnection(
                    properties.getProperty("url") + "/" + properties.getProperty("db_name"),
                    properties.getProperty("username"),
                    properties.getProperty("password")
            );
            statement = connect.createStatement();
            rows = statement.executeUpdate(sqlUpdate);
        } catch (SQLException ex) {
            System.out.println("Connection failed...");
            ex.printStackTrace();
        }
        return rows;
    }

    @Override
    public void close() {
        try {
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
