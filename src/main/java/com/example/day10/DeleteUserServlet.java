package com.example.day10;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteProfile")
public class DeleteUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            // Kullanıcının profilini veritabanından silme işlemini yapın
            UserDAO userDAO = new UserDAO();
            boolean deleteResult = userDAO.deleteUser(user.getId());

            if (deleteResult) {
                // Silme işlemi başarılıysa kullanıcıyı login sayfasına yönlendirin
                session.invalidate();
                response.sendRedirect("login.jsp");
            } else {
                // Silme işlemi başarısızsa kullanıcıyı hata sayfasına yönlendirin
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
