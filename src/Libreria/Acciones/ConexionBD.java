package Libreria.Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Atributos para la conexión
    static final String SERVER_IP = "10.14.0.62";
    static final String DB_NAME = "Biblioteca";
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@" + SERVER_IP + ":1521:" + "ORCL";

    // Database credentials
    static final String USER = "oihang";
    static final String PASSWORD = "zubiri";

    private Connection connection;

    // Constructor (establecer conexion)
    public ConexionBD() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para cerrar la conexión
    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Conexión cerrada.");
        }
    }

    // Getter para obtener la conexión
    public Connection getConexion() {
        return connection;
    }
}
