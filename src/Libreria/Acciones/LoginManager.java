package Libreria.Acciones;

import Libreria.Excepciones.InvalidCredentialsException;

import java.sql.*;

public class LoginManager {
    private Connection conexion;

    public LoginManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public boolean login(String username, String password) throws InvalidCredentialsException {
        // Hay que revisar bien el codigo aun.
       if (!validarCredenciales(username, password)){
           throw new InvalidCredentialsException("Credenciales invalidas");
       }
       return true;
    }

    public boolean validarCredenciales(String username, String password){
        try {
            String query = "SELECT * FROM usuario WHERE id_usuario = ? AND password = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
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
