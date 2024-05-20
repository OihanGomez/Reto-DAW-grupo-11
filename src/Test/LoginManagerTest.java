package Test;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        @ParameterizedTest
        @CsvFileSource(resources = "login_failure.csv")
        void testLoginFailure(String username, String password) {
            assertFalse(loginManager.login(username, password));
        }
    }

    @Nested
    class AdminTests {

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testIsAdminTrue() {
            assertTrue(loginManager.isAdmin("maria@example.com"));
        }

        @Test
        void testIsAdminFalse() {
            assertFalse(loginManager.isAdmin("juan@example.com"));
        }
    }
}
