package Libreria.Acciones;

import Libreria.objetos.Libro;

import java.sql.*;

public class BuscadorLibro {
    private Connection conexion;
    public BuscadorLibro(ConexionBD conexionBD) {
        this.conexion = conexionBD.getConexion();
    }

    public Libro buscarLibro(String tituloLibro) {

            String sql = "SELECT * FROM libros WHERE titulo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, tituloLibro);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Integer id_libro = resultSet.getInt("id_libro");
                    String titulo = resultSet.getString("titulo");
                    String descripcion = resultSet.getString("descripcion");
                    Double precio = resultSet.getDouble("precio");
                    Integer id_editorial = resultSet.getInt("id_editorial");
                    String portadaRuta = resultSet.getString("rutaImagen");

                    Libro libro = new Libro(id_libro,titulo,descripcion,precio,id_editorial,portadaRuta);

                    return libro;

                } else {
                    System.out.println("Libro no encontrado.");
                    return null;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
}
