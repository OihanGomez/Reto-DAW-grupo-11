package Test;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginManagerTest {

    private static ConexionBD conexionBD;
    private static LoginManager loginManager;

    @BeforeAll
    public static void setUp() throws Exception {
        // Inicializar la instancia de ConexionBD y LoginManager
        conexionBD = new ConexionBD();
        loginManager = new LoginManager(conexionBD);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        // Cerrar la conexión a la base de datos
        conexionBD.desconectar();
    }

    @Nested
    class LoginTests {

        @Test
        void testLoginSuccess() {
            assertTrue(loginManager.login("juan@example.com", "contraseña123"));
        }

        @Test
        void testLoginFailure() {
            assertFalse(loginManager.login("usuario_invalido@example.com", "contraseña_invalida"));
        }
    }

    @Nested
    class AdminTests {

        @Test
        void testIsAdminTrue() {
            assertTrue(loginManager.isAdmin("maria@example.com"));
        }

        @Test
        void testIsAdminFalse() {
            assertFalse(loginManager.isAdmin("juan@example.com"));
        }
    }
}
