package Utils;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Mailer {

    public static void send(String from, String to, String subject, String body) {
        // Thông số kết nối Gmail
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        // Đăng nhập Gmail
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = "binhnttv00241@gmail.com"; // 🔹 Thay bằng email của bạn
                String password = "qzoy bwbd hwpc gcsf";   // 🔹 App Password, không phải mật khẩu thật
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo mail
            MimeMessage mail = new MimeMessage(session);
            mail.setFrom(new InternetAddress(from));
            mail.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mail.setSubject(subject, "utf-8");
            mail.setText(body, "utf-8", "html");
            mail.setReplyTo(mail.getFrom());

            // Gửi mail
            Transport.send(mail);
            System.out.println("✅ Gửi mail thành công đến: " + to);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Gửi mail thất bại!");
        }
    }
}
