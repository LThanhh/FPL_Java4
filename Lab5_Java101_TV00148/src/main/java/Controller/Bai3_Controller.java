package Controller;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Bai3_Controller extends HttpServlet {

    // -----------------------------------------
    // doGet(): đọc cookie từ trình duyệt và tự điền form
    // -----------------------------------------
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    try {
                        // Giải mã Base64 để lấy lại username & password
                        String encoded = cookie.getValue();
                        byte[] bytes = Base64.getDecoder().decode(encoded);
                        String[] userInfo = new String(bytes).split(":");

                        // Gửi dữ liệu về lại form JSP
                        req.setAttribute("username", userInfo[0]);
                        req.setAttribute("password", userInfo[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Mở lại form đăng nhập
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    // -----------------------------------------
    // doPost(): xử lý đăng nhập & ghi cookie nếu Remember me
    // -----------------------------------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember-me");

        // Kiểm tra tài khoản (đề yêu cầu: FPT / poly)
        if ("FPT".equalsIgnoreCase(username) && "poly".equals(password)) {

            // Lưu session (phần này trong đề có)
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // Nếu người dùng tick Remember me
            if (remember != null) {
                // Mã hóa Base64: username:password
                String userInfo = username + ":" + password;
                String encoded = Base64.getEncoder().encodeToString(userInfo.getBytes());

                Cookie cookie = new Cookie("user", encoded);
                cookie.setMaxAge(30 * 24 * 60 * 60); // lưu 30 ngày
                resp.addCookie(cookie);
            } else {
                // Nếu không tick thì xóa cookie
                Cookie cookie = new Cookie("user", "");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

            // Gửi thông báo đăng nhập thành công
            req.setAttribute("message", "Login successfully!");
        } else {
            // Sai tài khoản
            req.setAttribute("message", "Invalid login info!");
        }

        // Quay lại trang login.jsp để hiển thị kết quả
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
