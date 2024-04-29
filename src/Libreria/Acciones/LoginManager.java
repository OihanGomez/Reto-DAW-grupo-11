package Libreria.Acciones;

import java.sql.*;
import java.util.Objects;

public class LoginManager {
    private Connection conexion;

    public LoginManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public boolean login(String email, String contrasena) {
        // Hay que revisar bien el codigo aun.
        try {
            String query = "SELECT * FROM usuarios WHERE email = ? AND contrasena = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("¡Inicio de sesión exitoso para " + email + "!");
                return true;
            } else {
                System.out.println("Email o contraseña incorrectos.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdmin(String email) {
        try {
            String query = "SELECT admin FROM usuarios WHERE email = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String admin = resultSet.getString("admin");
                return admin.equals("Y");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
