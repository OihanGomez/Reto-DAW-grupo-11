package Libreria.Acciones;

import java.sql.*;
import java.util.Objects;

public class LoginManager {
    private Connection conexion;

    public LoginManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public boolean login(String email, String contrasena) {
        String query = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, contrasena);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("¡Inicio de sesión exitoso para " + email + "!");
                    return true;
                } else {
                    System.out.println("Email o contraseña incorrectos.");
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isAdmin(String email) {
        String query = "SELECT admin FROM usuarios WHERE email = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String admin = resultSet.getString("admin");
                    return admin.equals("Y");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }


}
