/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Prestador;
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
public class PrestadorDAO {

    private Connection con;

    public PrestadorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //metodo cadastrar prestador
    public void cadastrarPrestador(Prestador obj) {
        try {
            //1 passo criar sql
            String sql = "insert into tb_prestador (nome, cpf, ap_visita, tipo_servico) values (?,?,?,?)";
            //2 passo conectar, organizar o bd
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getTipo_servico());
            //3 passo executar sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo alterar prestador
    public void alterarPrestador(Prestador obj) {
        try {
            //1 passo criar sql
            String sql = "update tb_prestador set nome=?, cpf=?, ap_visita=?, tipo_servico=? where id_prestador =?";
            //2 passo conectar, organizar o bd
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getTipo_servico());
            stmt.setInt(5, obj.getId_prestador());
            //3 passo executar sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    //metodo excluir prestador
    public void excluirPrestador(Prestador obj) {
        try {
            //1 passo criar sql
            String sql = "delete from tb_prestador where id_prestador = ?";
            //2 passo conectar, organizar o bd
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_prestador());
            //3 passo executar sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo listar prestador
    public List<Prestador> listarPrestador() {
        try {
            //1 passo criar lista
            List<Prestador> lista = new ArrayList<>();
            //2 passo criar o sql, organizar e executar
            String sql = "select * from tb_prestador";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Prestador obj = new Prestador();
                obj.setId_prestador(rs.getInt("id_prestador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_servico(rs.getString("tipo_servico"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    //metodo consulta por nome
    public Prestador consultaPorNome(String nome){
        try {
            //1 passo criar o sql, organizar e executar
            String sql = "select * from tb_prestador where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Prestador obj = new Prestador();
            if (rs.next()) {
                
                obj.setId_prestador(rs.getInt("id_prestador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_servico(rs.getString("tipo_servico"));

                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Prestador nao encontrado");
            return null;
        }
    }
    
    //metodo buscar por nome
    public List<Prestador> buscaPrestadorPorNome(String nome) {
        try {
            //1 passo criar lista
            List<Prestador> lista = new ArrayList<>();
            //2 passo criar o sql, organizar e executar
            String sql = "select * from tb_prestador where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Prestador obj = new Prestador();
                obj.setId_prestador(rs.getInt("id_prestador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_servico(rs.getString("tipo_servico"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    


}
