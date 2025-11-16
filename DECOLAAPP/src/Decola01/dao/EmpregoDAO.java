package Decola01.dao;

import Decola02.entity.Empregos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpregoDAO {
    public List<Empregos> listarPorProfissao(int profissaoId) {
        List<Empregos> lista = new ArrayList<>();
        String sql = "SELECT * FROM empregos WHERE profissao_id = ?";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, profissaoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empregos e = new Empregos(rs.getString("nome"));
                lista.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar empregos: " + e.getMessage());
        }
        return lista;
    }
}
