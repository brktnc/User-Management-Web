package com.example.day10;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String profile_picture = request.getParameter("profile_picture");
            String bio = request.getParameter("bio");

            user.setUsername(username);
            user.setEmail(email);
            user.setProfile_picture(profile_picture);
            user.setBio(bio);

            UserDAO userDAO = new UserDAO();
            boolean updateResult = userDAO.updateUser(user);

            if (updateResult) {
                // Güncelleme başarılıysa, kullanıcının bilgilerini güncellediğimiz
                // için tekrar session'a atayalım.
                session.setAttribute("user", user);

                response.sendRedirect("profile.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        } else {
            response.sendRedirect("profile.jsp");
        }
    }
}
