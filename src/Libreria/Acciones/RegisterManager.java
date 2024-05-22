package Libreria.Acciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterManager {
    private Connection conexion;

    public RegisterManager(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public boolean register(String email, String password, String name, String lastName, String address) {
        if (emailExists(email)) {
            System.out.println("El correo electrónico ya está registrado.");
            return false;
        }

        String query = "INSERT INTO usuarios (id_usuario, direccion, apellidos, nombre, email, admin, contrasena) " +
                "VALUES (new_usuario_seq.nextval, ?, ?, ?, ?, 'N', ?)";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, address); // Dirección
            statement.setString(2, lastName); // Apellidos
            statement.setString(3, name); // Nombre
            statement.setString(4, email); // Email
            statement.setString(5, password); // Contraseña

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Registro exitoso para " + email + "!");
                return true;
            } else {
                System.err.println("No se pudo completar el registro para " + email + ".");
            }
        } catch (SQLException e) {
            logError("Error al registrar el usuario: " + email, e);
        }
        return false;
    }

    private boolean emailExists(String email) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            logError("Error al verificar si el correo electrónico existe: " + email, e);
        }
        return false;
    }

    private void logError(String message, SQLException e) {
        // Aquí podrías usar un sistema de logging como Log4j, SLF4J, etc.
        System.err.println(message);
        e.printStackTrace(System.err);
    }

}
