package Libreria.Acciones;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminManagement {
    private  Connection conexion;

    public AdminManagement(ConexionBD conexion) {
        this.conexion = conexion.getConexion();
    }


    public void mostrarUsuarios(JComboBox<String> comboBox) {
        String query = "SELECT email FROM usuarios";

        try (PreparedStatement statement = conexion.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                comboBox.addItem(email);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener los usuarios: " + e.getMessage());
        }
    }



    public void actualizarUsuario(String selectedUser, String nuevaDireccion, String nuevoNombre, String nuevosApellidos, String nuevoCorreo, String nuevaContrasena) {
        String query = "UPDATE usuarios SET direccion = ?, nombre = ?, apellidos = ?, email = ?, contrasena = ? WHERE email = ?";

        try (PreparedStatement statement = conexion.prepareStatement(query)) {
            statement.setString(1, nuevaDireccion);
            statement.setString(2, nuevoNombre);
            statement.setString(3, nuevosApellidos);
            statement.setString(4, nuevoCorreo);
            statement.setString(5, nuevaContrasena);
            statement.setString(6, selectedUser);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Información actualizada exitosamente para el usuario: " + selectedUser);
            } else {
                System.out.println("No se encontró ningún usuario con el correo: " + selectedUser);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el usuario: " + e.getMessage());
        }
    }

}
