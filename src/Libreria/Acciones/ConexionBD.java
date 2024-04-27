package Libreria.Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase proporciona funcionalidad para establecer y manejar una conexión a una base de datos Oracle.
 */
public class ConexionBD {
    // Atributos para la conexión
    static final String SERVER_IP = "10.14.0.55";
    static final String DB_NAME = "Biblioteca";
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:" + SERVER_IP + ":1521/" + DB_NAME;

    // Credenciales de la base de datos
    static final String USER = "grupo11";
    static final String PASSWORD = "grupo11";

    private Connection connection;

    /**
     * Constructor de la clase ConexionBD. Establece una conexión a la base de datos utilizando las credenciales predeterminadas.
     */
    public ConexionBD() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Conectando a la base de datos...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Conectado.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra la conexión a la base de datos si no está cerrada ya.
     *
     * @throws SQLException Si ocurre un error al cerrar la conexión.
     */
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }

    /**
     * Obtiene la conexión a la base de datos.
     *
     * @return La conexión a la base de datos.
     */
    public Connection getConexion() {
        return connection;
    }
}
