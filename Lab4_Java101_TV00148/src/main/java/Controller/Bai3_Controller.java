package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Bai3_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Hiển thị form khi người dùng truy cập lần đầu
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Đọc dữ liệu từ form
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String married = req.getParameter("married");
        String country = req.getParameter("country");
        String note = req.getParameter("note");

        // hobbies có thể có nhiều giá trị
        String[] hobbies = req.getParameterValues("hobbies");

        // Ghép các sở thích lại thành chuỗi
        String hobbiesList = "";
        if (hobbies != null) {
            hobbiesList = String.join(", ", hobbies);
        }

        // In ra console (để kiểm tra)
        System.out.println("Tên đăng nhập: " + username);
        System.out.println("Mật khẩu: " + password);
        System.out.println("Giới tính: " + gender);
        System.out.println("Đã có gia đình: " + married);
        System.out.println("Quốc tịch: " + country);
        System.out.println("Sở thích: " + hobbiesList);
        System.out.println("Ghi chú: " + note);

        // Gửi kết quả lên lại trang JSP
        String msg = "Chào " + username + "!<br>"
                + "Giới tính: " + gender + "<br>"
                + "Quốc tịch: " + country + "<br>"
                + "Sở thích: " + hobbiesList + "<br>"
                + "Ghi chú: " + note;
        req.setAttribute("message", msg);

        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
