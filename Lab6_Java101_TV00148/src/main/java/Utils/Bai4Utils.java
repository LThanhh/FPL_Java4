package Utils;

import java.sql.*;

public class Bai4Utils {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=HRM;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    static String username = "sa";
    static String password = "123";

    static {
        try {
            Class.forName(driver);
            System.out.println("✅ SQL Server Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ Cannot load driver!", e);
        }
    }

    // Kết nối
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Thực thi lệnh INSERT, UPDATE, DELETE qua Stored Procedure
    public static int executeUpdate(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall(sql);
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
        return statement.executeUpdate();
    }

    // Truy vấn dữ liệu (SELECT)
    public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        CallableStatement statement = connection.prepareCall(sql);
        for (int i = 0; i < values.length; i++) {
            statement.setObject(i + 1, values[i]);
        }
        return statement.executeQuery();
    }
}
