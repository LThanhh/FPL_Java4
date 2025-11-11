package Main;

import Utils.Bai2Utils;
import java.sql.ResultSet;

public class Bai2Run {
    public static void main(String[] args) {
        //  Thực thi câu SELECT
        try {
            String sql = "SELECT * FROM Employees";
            ResultSet result = Bai2Utils.executeQuery(sql);

            while (result.next()) {
                String id = result.getString("Id");
                String fullname = result.getString("Fullname");
                double salary = result.getDouble("Salary");

                System.out.println("Mã NV: " + id + " | Họ tên: " + fullname + " | Lương: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Thực thi câu INSERT / UPDATE / DELET
        try {
            String sql = "UPDATE Employees SET Salary = Salary + 1000000 WHERE DepartmentId = 'D01'";
            int rows = Bai2Utils.executeUpdate(sql);
            System.out.println("Số dòng bị ảnh hưởng: " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
