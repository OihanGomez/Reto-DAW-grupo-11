package Libreria;

import static org.junit.Assert.*;
import org.junit.*;
import Libreria.Acciones.*;

public class LoginManagerTest {
    private static ConexionBD conexionBD;
    private static LoginManager loginManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        conexionBD = new ConexionBD(); // O ajusta esto si necesitas configuración específica
        loginManager = new LoginManager(conexionBD);
    }

    @Test
    public void testLogin() {
        // Prueba de inicio de sesión con credenciales válidas
        assertTrue(loginManager.login("juan@example.com", "contraseña123"));

        // Prueba de inicio de sesión con credenciales inválidas
        assertFalse(loginManager.login("usuario_invalido@example.com", "contraseña_invalida"));
    }

}
