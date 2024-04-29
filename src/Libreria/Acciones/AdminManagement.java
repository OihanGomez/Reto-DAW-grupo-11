package Libreria.Acciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class AdminManagement {
    private  Connection conexion;

    public AdminManagement(ConexionBD conexion) {
        this.conexion = conexion.getConexion();
    }


    public void mostrarUsuarios(JComboBox<String> comboBox) {
        try {
            PreparedStatement statement = conexion.prepareStatement("SELECT email FROM usuarios");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("email");
                comboBox.addItem(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void actualizarUsuario(String selectedUser, String nuevaDireccion, String nuevoNombre, String nuevosApellidos, String nuevoCorreo, String nuevaContrasena) {
        try {
            PreparedStatement statement = conexion.prepareStatement("UPDATE usuarios SET direccion = ?, nombre = ?, apellidos = ?, email = ?, contrasena = ? WHERE email = ?");
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
                System.out.println("No se encontró ningún usuario con el nombre de usuario: " + selectedUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
