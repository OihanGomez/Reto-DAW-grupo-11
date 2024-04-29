package Test;

import static org.junit.Assert.*;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.*;

public class LoginManagerTest {

    private static ConexionBD conexionBD;
    private static LoginManager loginManager;

    @BeforeClass
    public static void setUp() throws Exception {
        // Inicializar la instancia de ConexionBD y LoginManager
        conexionBD = new ConexionBD();
        loginManager = new LoginManager(conexionBD);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        // Cerrar la conexión a la base de datos
        conexionBD.desconectar();
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(loginManager.login("juan@example.com", "contraseña123"));
    }

    @Test
    public void testLoginFailure() {
        assertFalse(loginManager.login("usuario_invalido", "contraseña_invalida"));
    }

    @Test
    public void testIsAdminTrue() {
        assertTrue(loginManager.isAdmin("usuario_administrador"));
    }

    @Test
    public void testIsAdminFalse() {
        assertFalse(loginManager.isAdmin("juan@example.com"));
    }
}
