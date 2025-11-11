package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
	"/bai4",
    "/crud/create",
    "/crud/update",
    "/crud/delete",
    "/crud/edit/2024"
})
public class Bai4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String path = request.getServletPath();

        switch (path) {
	        case "/bai4":
	        	response.getWriter().println("<h1>Đây là Bài 4</h1>");
	            break;
            case "/crud/create":
                response.getWriter().println("<h3>Thực hiện chức năng CREATE</h3>");
                break;
            case "/crud/update":
                response.getWriter().println("<h3>Thực hiện chức năng UPDATE</h3>");
                break;
            case "/crud/delete":
                response.getWriter().println("<h3>Thực hiện chức năng DELETE</h3>");
                break;
            case "/crud/edit/2024":
                response.getWriter().println("<h3>Thực hiện chức năng EDIT với ID = 2024</h3>");
                break;
            default:
                response.getWriter().println("<h3>Không tìm thấy chức năng phù hợp!</h3>");
                break;
        }
    }
}
