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
            PreparedStatement statement = conexion.prepareStatement("SELECT username FROM usuarios");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                comboBox.addItem(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void actualizarUsuario(String username, String nuevaDireccion, String nuevoNombre, String nuevosApellidos, String nuevoCorreo, String nuevaContraseña) {
        try {
            PreparedStatement statement = conexion.prepareStatement("UPDATE usuarios SET direccion = ?, nombre = ?, apellidos = ?, correo = ?, contraseña = ? WHERE username = ?");
            statement.setString(1, nuevaDireccion);
            statement.setString(2, nuevoNombre);
            statement.setString(3, nuevosApellidos);
            statement.setString(4, nuevoCorreo);
            statement.setString(5, nuevaContraseña);
            statement.setString(6, username);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Información actualizada exitosamente para el usuario: " + username);
            } else {
                System.out.println("No se encontró ningún usuario con el nombre de usuario: " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
