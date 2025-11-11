package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bai3")
public class Bai3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<h2>THÔNG TIN URL</h2>");
        out.println("1. URL: " + request.getRequestURL().toString() + "<br>");
        out.println("2. URI: " + request.getRequestURI() + "<br>");
        out.println("3. QueryString: " + request.getQueryString() + "<br>");
        out.println("4. ServletPath: " + request.getServletPath() + "<br>");
        out.println("5. ContextPath: " + request.getContextPath() + "<br>");
        out.println("6. PathInfo: " + request.getPathInfo() + "<br>");
        out.println("7. Method: " + request.getMethod() + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}