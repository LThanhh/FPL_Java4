package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.User;

@WebServlet({"/form/update2", "/form/create2"})
public class FormServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Dữ liệu mẫu ban đầu
        User bean = new User();
        bean.setFullname("Nguyễn Văn Tèo");
        bean.setGender(true);
        bean.setCountry("VN");

        req.setAttribute("user", bean);
        req.getRequestDispatcher("/form/form2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
        String uri = req.getRequestURI();
        // Nhận dữ liệu người dùng nhập
        String fullname = req.getParameter("fullname");
        String genderStr = req.getParameter("gender");
        String country = req.getParameter("country");
        boolean gender = Boolean.parseBoolean(genderStr);

        // Gán vào JavaBean
        User bean = new User();
        bean.setFullname(fullname);
        bean.setGender(gender);
        bean.setCountry(country);

        // Gửi lại sang JSP
        req.setAttribute("user", bean);

        if (uri.endsWith("/form/update2")) {
            req.setAttribute("capnhat", "Update success!");
            req.getRequestDispatcher("/form/form2.jsp").forward(req, resp);
        } 
        else if (uri.endsWith("/form/create2")) {
        	req.setAttribute("caller", "update2");
        	req.getRequestDispatcher("/form/themmoi.jsp").forward(req, resp);
        }
    }
}
