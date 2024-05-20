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
        try {
            // Verificar si el correo electrónico ya está registrado
            if (emailExists(email)) {
                System.out.println("El correo electrónico ya está registrado.");
                return false;
            }

            // Insertar nuevo usuario en la base de datos
            String query = "INSERT INTO usuarios (id_usuario, direccion, apellidos, nombre, email, admin, contrasena) " +
                    "VALUES (new_usuario_seq.nextval, ?, ?, ?, ?, 'N', ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, address); // Dirección
            statement.setString(2, lastName); // Apellidos
            statement.setString(3, name); // Nombre
            statement.setString(4, email); // Email
            statement.setString(5, password); // Contraseña

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Registro exitoso para " + email + "!");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    private boolean emailExists(String email) {
        try {
            String query = "SELECT * FROM usuarios WHERE email = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            return resultSet.next(); // Retorna true si existe algún resultado
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
