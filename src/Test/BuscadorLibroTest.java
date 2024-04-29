package Test;

import static org.junit.jupiter.api.Assertions.*;

import Libreria.Acciones.BuscadorLibro;
import Libreria.Acciones.ConexionBD;
import org.junit.jupiter.api.*;

class BuscadorLibroTest {

    private static ConexionBD conexionBD;
    private static BuscadorLibro buscadorLibro;

    @BeforeAll
    static void setUp() {
        conexionBD = new ConexionBD();
        buscadorLibro = new BuscadorLibro(conexionBD);
    }

    @AfterAll
    static void tearDown() {
    }

    @Test
    @DisplayName("Prueba de búsqueda de libro existente")
    void testBuscarLibroExistente() {
        assertNotNull(buscadorLibro.buscarLibro("El Señor de los Anillos"), "El libro debería existir en la base de datos");
    }

    @Test
    @DisplayName("Prueba de búsqueda de libro inexistente")
    void testBuscarLibroInexistente() {
        assertNull(buscadorLibro.buscarLibro("libroQueNoExiste"), "El libro no debería existir en la base de datos");
    }
}
