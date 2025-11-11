package Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;
import Model.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class Bai1_Controller extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	Staff bean = new Staff(); // dùng để chứa dữ liệu form 
    	try { 
    	// Khai báo định dạng ngày 
    	DateTimeConverter dtc = new DateConverter(new Date()); 
    	dtc.setPattern("MM/dd/yyyy"); 
    	ConvertUtils.register(dtc, Date.class); 
    	// đọc và chuyển đổi tham số vào bean 
    	BeanUtils.populate(bean, req.getParameterMap()); 
    	System.out.println("Fullname: " + bean.getFullname());
    	System.out.println("Birthday: " + bean.getBirthday());
    	System.out.println("Gender: " + bean.isGender());
    	System.out.println("Country: " + bean.getCountry());
    	System.out.println("Salary: " + bean.getSalary());
    	System.out.println("Hobbies: " + Arrays.toString(bean.getHobbies()));
    	} catch (Exception e) { 
    	e.printStackTrace(); 
    	} 
    }
}
