package Controller;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig()
public class Bai4_Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Part photo = req.getPart("photo");
        if (photo == null || photo.getSize() == 0) {
            req.setAttribute("message", "Vui lòng chọn file!");
            req.getRequestDispatcher("/upload.jsp").forward(req, resp);
            return;
        }

        // Tên file gốc
        String original = photo.getSubmittedFileName();

        // Thư mục 
        String webPath = "/static/file/" + original;
        String diskPath = req.getServletContext().getRealPath(webPath);

        // Tạo thư mục nếu chưa tồn tại
        File target = new File(diskPath).getParentFile();
        if (!target.exists()) target.mkdirs();

        // Ghi file
        photo.write(diskPath);

        // Thông báo + đường dẫn ảnh để hiển thị
        req.setAttribute("message", "Upload thành công: " + original);
        req.setAttribute("photoPath", req.getContextPath() + webPath);

        // Forward
        req.getRequestDispatcher("/upload.jsp").forward(req, resp);
    }
}
