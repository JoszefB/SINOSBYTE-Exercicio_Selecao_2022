package DAO;


import Config.Conexao;
import Model.Aluno;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlunoDAO {

    public void criarAluno(Aluno a){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into aluno (codAluno, nomeAluno, nota1, nota2, media, aprovado) values (?,?,?,?,?,?)");
            stmt.setInt(1, a.getCodAluno());
            stmt.setString(2, a.getNomeAluno());
            stmt.setDouble(3, a.getNota1());
            stmt.setDouble(4, a.getNota2());
            stmt.setDouble(5, a.getMedia());
            stmt.setString(6, a.getAprovado());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluno inserido ao sistema com sucesso.");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Ops! Algum erro inexperado aconteceu!"+e);
        }
        finally {
            Conexao.closeConnection(con, stmt);

        }
    }
    public List<Aluno> pesquisaAluno(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno alu = new Aluno();
        List<Aluno> a = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM aluno WHERE codAluno = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()){

                alu.setCodAluno(rs.getInt("codAluno"));
                alu.setNomeAluno(rs.getString("nomeAluno"));
                alu.setNota1(rs.getDouble("nota1"));
                alu.setNota2(rs.getDouble("nota2"));
                alu.setMedia(rs.getDouble("media"));
                alu.setAprovado(rs.getString("aprovado"));
                a.add(alu);

            }


        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }
        return a;
    }
}