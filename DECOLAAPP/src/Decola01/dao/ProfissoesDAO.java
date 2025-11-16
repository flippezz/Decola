package Decola01.dao;

import Decola02.entity.Profissoes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfissoesDAO {
    public List<Profissoes> listar() {
        List<Profissoes> lista = new ArrayList<>();
        String sql = "SELECT * FROM profissoes";
        try (Connection con = ConnectionFactory.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Profissoes p = new Profissoes(rs.getString("nome"));
                p.setId(rs.getInt("id"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar profissões: " + e.getMessage());
        }
        return lista;
    }
}
