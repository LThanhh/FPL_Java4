package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bai3Utils {
    // Thông tin kết nối
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=HRM;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";
    private static final String username = "sa";
    private static final String password = "123";

    // Nạp driver
    static {
        try {
            Class.forName(driver);
            System.out.println("✅ SQL Server Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("❌ Driver not found!", e);
        }
    }

    // Kết nối CSDL
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Thực thi SELECT với tham số
    public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]); // Gán giá trị cho từng dấu ?
        }
        return stmt.executeQuery();
    }

    // Thực thi INSERT, UPDATE, DELETE với tham số
    public static int executeUpdate(String sql, Object... values) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            stmt.setObject(i + 1, values[i]);
        }
        return stmt.executeUpdate();
    }
}
