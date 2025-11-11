package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/bai4")
public class Bai4_Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, Object> map = new HashMap<>();
        map.put("title", "Tiêu đề bản tin");
        map.put("content", "Nội Dung Bản In");
        
        req.setAttribute("item", map);
        req.getRequestDispatcher("/Bai4.jsp").forward(req, resp);
    }
}
