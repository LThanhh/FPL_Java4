package Controller;

import java.io.IOException;
import Utils.Mailer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sendmail")
public class Bai2_Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String from = req.getParameter("from");
        String to = req.getParameter("to");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");

        Mailer.send(from, to, subject, body);

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<h3>Email đã được gửi đi!</h3>");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/sendmail.jsp").forward(req, resp);
    }
}
