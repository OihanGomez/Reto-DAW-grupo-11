package Test;

import Libreria.Acciones.ConexionBD;
import Libreria.Acciones.LoginManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    @RepeatedTest(3)
    public void testLoginSuccess() {
        assertTrue(loginManager.login("juan@example.com", "contraseña123"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "login_failure.csv")
    public void testLoginFailure(String username, String password) {
        assertFalse(loginManager.login(username, password));
    }
    @Test
    public void testIsAdminTrue() {
        assertTrue(loginManager.isAdmin("maria@example.com"));
    }

    @Test
    public void testIsAdminFalse() {
        assertFalse(loginManager.isAdmin("juan@example.com"));
    }
}
