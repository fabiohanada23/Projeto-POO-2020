/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Visitante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author fabioh
 */
public class VisitanteDAO {

    private Connection con;

    public VisitanteDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //metodo cadastrar visitante
    public void cadastrarVisitante(Visitante obj) {
        try {
            //1 passo criar sql
            String sql = "insert into tb_visitante (nome, cpf, ap_visita) values (?,?,?)";
            //2 passo conectar o bd e organizar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            //3 passo executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo alterar visitante
    public void alterarVisitante(Visitante obj) {
        try {
            //1 passo criar sql
            String sql = "update tb_visitante set nome=?, cpf=?, ap_visita=? where id_visitante = ?";
            //2 passo conectar o bd e organizar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());

            stmt.setInt(4, obj.getId_visitante());
            //3 passo executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo excluir visitante
    public void excluirVisitante(Visitante obj) {
        try {
            //1 passo criar sql
            String sql = "delete from tb_visitante where id_visitante = ?";
            //2 passo conectar o bd e organizar
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_visitante());
            //3 passo executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo listar visitante
    public List<Visitante> listarVisitante() {
        try {
            //1 passo criar lista
            List<Visitante> lista = new ArrayList<>();
            //2 passo criar sql
            String sql = "select * from tb_visitante";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Visitante obj = new Visitante();
                obj.setId_visitante(rs.getInt("id_visitante"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }

    //metodo consulta por nome
    public Visitante consultaPorNome(String nome) {
        try {
            //1 passo criar sql
            String sql = "select * from tb_visitante where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Visitante obj = new Visitante();
            if (rs.next()) {

                obj.setId_visitante(rs.getInt("id_visitante"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));

            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Visitante nao encontrado");
            return null;
        }

    }

    //metodo buscar visitante por nome
    public List<Visitante> buscaVisitantePorNome(String nome) {
        try {
            //1 passo criar lista
            List<Visitante> lista = new ArrayList<>();
            //2 passo criar sql
            String sql = "select * from tb_visitante where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Visitante obj = new Visitante();
                obj.setId_visitante(rs.getInt("id_visitante"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));

                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }

}
