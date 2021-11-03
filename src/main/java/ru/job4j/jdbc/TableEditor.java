package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("postgres.connection.driver_class"));
        String url = properties.getProperty("postgres.connection.url");
        String login = properties.getProperty("postgres.connection.username");
        String password = properties.getProperty("postgres.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void statement(String query) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(query);
        }
    }

    public void createTable(String tableName) throws Exception {
        statement(String.format(
                "create table if not exists %s ();",
                tableName
        ));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropTable(String tableName) throws Exception {
        statement(String.format(
                "drop table if exists %s;",
                tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        statement(String.format(
                "alter table %s add column %s %s;",
                tableName, columnName, type
        ));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        statement(String.format(
                "alter table %s drop column %s;",
                tableName, columnName
        ));
        System.out.println(getTableScheme(connection, tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        statement(String.format(
                "alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName
        ));
        System.out.println(getTableScheme(connection, tableName));
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var bufer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        bufer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                bufer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return bufer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("app.properties"));
        TableEditor table = new TableEditor(properties);
        table.createTable("test_table");
        table.addColumn("test_table", "name", "text");
        table.renameColumn("test_table", "name", "description");
        table.dropColumn("test_table", "description");
        table.dropTable("test_table");
        table.close();
    }
}
