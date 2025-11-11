package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/calculate","/calculate/add", "/calculate/sub"})
public class Bai2_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("message", "Nhập số và chọn phép tính");
        req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            double a = Double.parseDouble(req.getParameter("a"));
            double b = Double.parseDouble(req.getParameter("b"));
            String path = req.getServletPath();

            if (path.endsWith("/add")) {
                double c = a + b;
                req.setAttribute("message", a + " + " + b + " = " + c);
            } else if (path.endsWith("/sub")) {
                double c = a - b;
                req.setAttribute("message", a + " - " + b + " = " + c);
            }
        } catch (Exception e) {
            req.setAttribute("message", "Vui lòng nhập đúng số!");
        }

        req.getRequestDispatcher("/calculate.jsp").forward(req, resp);
    }
}
