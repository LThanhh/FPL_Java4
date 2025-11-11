package Main;

import Utils.Bai3Utils;
import java.sql.ResultSet;

public class Bai3Run {
    public static void main(String[] args) {

        // ----------------------------
        // 1️⃣ Truy vấn SELECT có tham số
        // ----------------------------
        try {
            String sql = "SELECT * FROM Employees WHERE DepartmentId = ?";
            ResultSet result = Bai3Utils.executeQuery(sql, "D01");

            while (result.next()) {
                String id = result.getString("Id");
                String fullname = result.getString("Fullname");
                double salary = result.getDouble("Salary");

                System.out.println("Mã NV: " + id + " | Họ tên: " + fullname + " | Lương: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Lệnh INSERT / UPDATE / DELETE có tham số
        try {
            String sql = "UPDATE Employees SET Salary = ? WHERE Id = ?";
            int rows = Bai3Utils.executeUpdate(sql, 20000000, "E001");

            System.out.println("Số dòng bị ảnh hưởng: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
