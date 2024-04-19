package Libreria.Acciones;

import java.sql.*;

public class BuscadorLibro {

    public void buscarLibro(String nombreLibro) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:libros.db")) {
            String sql = "SELECT * FROM libros WHERE nombre = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombreLibro);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String portada = rs.getString("portada");

                    System.out.println("Título: " + titulo);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("Portada: " + portada);
                } else {
                    System.out.println("Libro no encontrado.");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
