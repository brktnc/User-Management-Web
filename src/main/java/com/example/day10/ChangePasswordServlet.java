package com.example.day10;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String currentPassword = request.getParameter("currentPassword");
            String newPassword = request.getParameter("newPassword");

            // Mevcut şifre doğrulama işlemleri
            // Eğer mevcut şifre doğruysa yeni şifreyi veritabanında güncelle
            if (currentPassword.equals(user.getPassword())) {
                user.setPassword(newPassword);

                // Şifreyi veritabanında güncelleme işlemini yap
                UserDAO userDAO = new UserDAO();
                boolean updateResult = userDAO.updatePassword(user.getId(), newPassword);

                if (updateResult) {
                    response.sendRedirect("profile.jsp");
                } else {
                    // Güncelleme başarısızsa kullanıcıyı hata sayfasına yönlendiririz
                    response.sendRedirect("error.jsp");
                }
            } else {
                // Mevcut şifre yanlışsa kullanıcıyı şifre değiştirme sayfasına yönlendiririz
                response.sendRedirect("changePassword.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
