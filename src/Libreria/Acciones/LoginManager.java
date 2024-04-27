package Libreria.Acciones;

import java.sql.*;

public class LoginManager {
    private Connection conexion;

    /**
     * Construye un nuevo LoginManager utilizando la conexión proporcionada.
     *
     * @param conexionBD La instancia de ConexionBD utilizada para obtener la conexión a la base de datos.
     */
    public LoginManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    /**
     * Intenta iniciar sesión en el sistema con el nombre de usuario y la contraseña proporcionados.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @return true si el inicio de sesión es exitoso, false de lo contrario.
     * @throws SQLException Si ocurre un error de SQL durante la consulta.
     */
    public boolean login(String username, String password) {
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

    /**
     * Comprueba si un usuario tiene privilegios de administrador.
     *
     * @param username El nombre de usuario.
     * @return true si el usuario es administrador, false de lo contrario.
     * @throws SQLException Si ocurre un error de SQL durante la consulta.
     */
    public boolean isAdmin(String username) {
        try {
            String query = "SELECT admin FROM usuarios WHERE username = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                boolean isAdmin = resultSet.getBoolean("admin");
                return isAdmin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
