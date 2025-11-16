package Decola01.dao;

import java.sql.*;

public class TesteVocacionalDAO {
    public void inserir(int usuarioId, String resultado) {
        String sql = "INSERT INTO teste_vocacional (usuario_id, resultado) VALUES (?, ?)";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, usuarioId);
            ps.setString(2, resultado);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro ao inserir teste: " + e.getMessage());
        }
    }
}
