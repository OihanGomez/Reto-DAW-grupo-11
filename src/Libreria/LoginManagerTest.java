package Libreria;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginManagerTest {
    private static ConexionBD conexionBD;
    private static LoginManager loginManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        conexionBD = new ConexionBD();
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
