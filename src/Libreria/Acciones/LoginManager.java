package Libreria.Acciones;

import java.sql.*;

public class LoginManager {
    private Connection conexion;

    public LoginManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public boolean login(String username, String password) {
        // Hay que revisar bien el codigo aun.
        try {
            String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("¡Inicio de sesión exitoso para " + username + "!");
                return true;
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAdmin (String username){
        try{
            String query = "SELECT admin FROM usuarios WHERE username = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                boolean isAdmin = resultSet.getBoolean("admin");
                return isAdmin;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
