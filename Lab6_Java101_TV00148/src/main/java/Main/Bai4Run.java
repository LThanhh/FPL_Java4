package Main;

import Utils.Bai4Utils;
import java.sql.ResultSet;

public class Bai4Run {
    public static void main(String[] args) {
        //  Truy vấn tất cả (spSelectAll)
        try {
            String sql = "{CALL spSelectAll()}";
            ResultSet rs = Bai4Utils.executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Id");
                String name = rs.getString("Name");
                String desc = rs.getString("Description");
                System.out.println("Mã phòng: " + id + " | Tên: " + name + " | Mô tả: " + desc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Thêm mới phòng ban (spInsert)
        try {
            String sql = "{CALL spInsert(?, ?, ?)}";
            int rows = Bai4Utils.executeUpdate(sql, "D05", "Phòng Marketing", "Chuyên về quảng cáo");
            System.out.println("Đã thêm: " + rows + " phòng ban mới");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //  Cập nhật phòng ban (spUpdate)
        try {
            String sql = "{CALL spUpdate(?, ?, ?)}";
            int rows = Bai4Utils.executeUpdate(sql, "D05", "Phòng Marketing Online", "Quản lý kênh trực tuyến");
            System.out.println("Đã cập nhật: " + rows + " phòng ban");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Truy vấn theo mã (spSelectById)
        try {
            String sql = "{CALL spSelectById(?)}";
            ResultSet rs = Bai4Utils.executeQuery(sql, "D05");
            while (rs.next()) {
                System.out.println("➡ " + rs.getString("Id") + " - " + rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //  Xóa theo mã (spDeleteById)
        try {
            String sql = "{CALL spDeleteById(?)}";
            int rows = Bai4Utils.executeUpdate(sql, "D05");
            System.out.println("Đã xóa: " + rows + " phòng ban");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
