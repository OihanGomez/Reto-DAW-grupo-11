package Libreria.Acciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitasManager {
    private ConexionBD conexionBD;

    public CitasManager() {
        conexionBD = new ConexionBD();
    }

    public void reservarCita(String email, String fecha) throws Exception {
        Connection connection = conexionBD.getConexion();
        String checkQuery = "SELECT COUNT(*) FROM CITAS WHERE EMAIL = ? AND FECHA = TO_DATE(?, 'YYYY/MM/DD')";
        String insertQuery = "INSERT INTO CITAS (EMAIL, FECHA) VALUES (?, TO_DATE(?, 'YYYY/MM/DD'))";

        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setString(1, email);
            checkStmt.setString(2, fecha);

            try (ResultSet rs = checkStmt.executeQuery()) {
                rs.next();
                if (rs.getInt(1) > 0) {
                    throw new Exception("La fecha ya está ocupada para este usuario.");
                }
            }
        }

        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setString(1, email);
            insertStmt.setString(2, fecha);
            insertStmt.executeUpdate();
        }
    }

    public boolean isFechaOcupada(String fecha) throws SQLException {
        Connection connection = conexionBD.getConexion();
        String query = "SELECT COUNT(*) FROM CITAS WHERE FECHA = TO_DATE(?, 'YYYY/MM/DD')";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, fecha);

            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        }
    }
}
