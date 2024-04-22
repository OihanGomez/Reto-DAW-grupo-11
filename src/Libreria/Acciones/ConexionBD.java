package Libreria.Acciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Atributos para la conexión
    private String url;
    private String usuario;
    private String contraseña;
    private Connection conexion;

    // Constructor
    public ConexionBD(String url, String usuario, String contraseña) {
        this.url = url;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Método para establecer la conexión
    public void conectar() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            try {
                conexion = DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("Conexión establecida.");
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
                throw e;
            }
        }
    }

    // Método para cerrar la conexión
    public void desconectar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
            System.out.println("Conexión cerrada.");
        }
    }

    // Getter para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
}
