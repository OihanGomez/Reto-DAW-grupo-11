package Test;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.RegisterManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterManagerTest {
    private ConexionBD conexionBD;
    private RegisterManager registerManager;

    @Before
    public void setUp() {
        conexionBD = new ConexionBD();
        registerManager = new RegisterManager(conexionBD);
    }

    @After
    public void tearDown() throws SQLException {
        conexionBD.desconectar();
    }

    @Test
    public void testRegister() throws SQLException {
        // Ejecutar el método register con datos de prueba
        boolean registrationResult = registerManager.register("test@example.com", "password123", "John", "Doe", "123 Test St");

        // Verificar si el registro fue exitoso
        assertTrue(registrationResult);

        // Verificar si el usuario fue insertado en la base de datos
        try (Connection connection = conexionBD.getConexion();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE email = ?");
        ) {
            statement.setString(1, "test@example.com");
            ResultSet resultSet = statement.executeQuery();
            assertTrue(resultSet.next());
            assertEquals("John", resultSet.getString("nombre"));
            assertEquals("Doe", resultSet.getString("apellidos"));
            assertEquals("123 Test St", resultSet.getString("direccion"));
            assertEquals("N", resultSet.getString("admin"));
            // Puedes verificar más campos aquí según tus necesidades
        }
    }

    @Test
    public void testRegisterWithExistingEmail() throws SQLException {
        // Insertar un usuario con el mismo correo electrónico antes de realizar el registro
        try (Connection connection = conexionBD.getConexion();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (email, direccion, apellidos, nombre, contrasena) VALUES (?, ?, ?, ?, ?)");
        ) {
            statement.setString(1, "test@example.com");
            statement.setString(2, "123 Test St");
            statement.setString(3, "Doe");
            statement.setString(4, "John");
            statement.setString(5, "password123");
            statement.executeUpdate();
        }

        // Intentar registrar con el mismo correo electrónico
        boolean registrationResult = registerManager.register("test@example.com", "password123", "John", "Doe", "123 Test St");

        // Verificar que el registro haya fallado
        assertFalse(registrationResult);
    }
}