package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/bai2")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Gửi thông báo
        req.setAttribute("message", "Welcome to FPT Polytechnic!");

        // Tạo map chứa thông tin người dùng
        Map<String, Object> map = new HashMap<>();
        map.put("fullname", "Nguyễn Văn Tèo");
        map.put("gender", "Male");
        map.put("country", "Việt Nam");

        // Đưa map vào request
        req.setAttribute("user", map);

        // Chuyển đến trang JSP
        req.getRequestDispatcher("/page2.jsp").forward(req, resp);
    }
}
