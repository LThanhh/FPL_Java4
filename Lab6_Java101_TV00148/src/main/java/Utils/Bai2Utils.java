package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai2Utils {
    // Thông tin kết nối
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=HRM;encrypt=true;trustServerCertificate=true;";
    private static final String username = "sa";
    private static final String password = "123";

    // Nạp driver SQL Server
    static {
        try {
            Class.forName(driver);
            System.out.println("✅ SQL Server Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: Driver not found!");
            throw new RuntimeException(e);
        }
    }

    // Kết nối CSDL
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Thực thi câu lệnh SELECT (trả về ResultSet)
    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    // Thực thi câu lệnh INSERT, UPDATE, DELETE (trả về số dòng bị ảnh hưởng)
    public static int executeUpdate(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }
}
