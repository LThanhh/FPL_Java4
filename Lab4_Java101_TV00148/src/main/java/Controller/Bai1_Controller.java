package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/account/login")
public class Bai1_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Khi người dùng truy cập trang lần đầu
        req.setAttribute("message", "Enter username and password");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Khi người dùng nhấn nút Login
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equalsIgnoreCase("FPT") && password.equals("poly")) {
            req.setAttribute("message", "Login successfully");
        } else {
            req.setAttribute("message", "Invalid username or password");
        }

        // Hiển thị lại trang login.jsp cùng thông báo
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
