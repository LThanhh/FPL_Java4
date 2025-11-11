package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/bai3")
public class Bai3_Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "iPhone 2024");
        map.put("price", 12345.678);
        map.put("date", new Date());

        req.setAttribute("item", map);
        req.getRequestDispatcher("/Bai3.jsp").forward(req, resp);
    }
}
