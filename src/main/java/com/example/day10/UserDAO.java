package com.example.day10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAO {
    public boolean updatePassword(int userId, String newPassword) {

        try (Connection connection = DatabaseConnection.getConnection()){
            String query = "UPDATE users SET password = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, userId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; // Güncelleme başarılıysa true, değilse false döndürür

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int userId) {


        try (Connection connection = DatabaseConnection.getConnection()){
            String sql = "DELETE FROM users WHERE id = ?";
             PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, userId);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0; // Silme başarılıysa true, değilse false döndürür

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateUser(User user) {


        try (Connection connection = DatabaseConnection.getConnection()){
             String sql = "UPDATE users SET username = ?, email = ?, password = ?, profile_picture = ?, bio = ? WHERE id = ?";
             PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getProfile_picture());
            statement.setString(5, user.getBio());
            statement.setInt(6, user.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; // Güncelleme başarılıysa true, değilse false döndürür

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
