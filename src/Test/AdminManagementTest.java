package Test;

import Libreria.Acciones.AdminManagement;
import Libreria.Acciones.ConexionBD;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class AdminManagementTest {
    private ConexionBD conexionBD;
    private AdminManagement adminManagement;

    @Before
    public void setUp() {
        conexionBD = new ConexionBD();
        adminManagement = new AdminManagement(conexionBD);

        // Crear la tabla de usuarios si no existe
        try (Connection connection = conexionBD.getConexion();
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS usuarios (email TEXT PRIMARY KEY, direccion TEXT, nombre TEXT, apellidos TEXT, contrasena TEXT)");
        } catch (SQLException e) {
            fail("Error al crear la tabla de usuarios: " + e.getMessage());
        }
    }

    @After
    public void tearDown() throws SQLException {
        conexionBD.desconectar();
    }

    @Test
    public void testMostrarUsuarios() throws SQLException {
        // Insertar datos de prueba
        try (Connection connection = conexionBD.getConexion();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO usuarios (email, direccion, nombre, apellidos, contrasena) VALUES ('test@example.com', '123 Test St', 'Test', 'User', 'password')");
        }

        JComboBox<String> comboBox = new JComboBox<>();
        adminManagement.mostrarUsuarios(comboBox);

        assertEquals(1, comboBox.getItemCount());
        assertEquals("test@example.com", comboBox.getItemAt(0));
    }

    @Test
    public void testActualizarUsuario() throws SQLException {
        // Insertar datos de prueba
        try (Connection connection = conexionBD.getConexion();
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO usuarios (email, direccion, nombre, apellidos, contrasena) VALUES ('test@example.com', '123 Test St', 'Test', 'User', 'password')");
        }

        adminManagement.actualizarUsuario("test@example.com", "456 New St", "NewName", "NewSurname", "new@example.com", "newpassword");

        // Verificar resultados
        try (Connection connection = conexionBD.getConexion();
             Statement statement = connection.createStatement();
             var resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE email = 'new@example.com'")) {
            assertTrue(resultSet.next());
            assertEquals("456 New St", resultSet.getString("direccion"));
            assertEquals("NewName", resultSet.getString("nombre"));
            assertEquals("NewSurname", resultSet.getString("apellidos"));
            assertEquals("new@example.com", resultSet.getString("email"));
            assertEquals("newpassword", resultSet.getString("contrasena"));
        }
    }
}