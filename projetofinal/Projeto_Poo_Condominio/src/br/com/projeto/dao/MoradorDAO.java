/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Morador;
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
public class MoradorDAO {

    private Connection conn;

    public MoradorDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    //metodo cadatrar morador
    public void cadastrarMorador(Morador obj) {
        try {
            //1 passo criar sql
            String sql = "insert into tb_morador (nome, cpf, email, celular) values (?,?,?,?)";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

       //metodo alterar morador
    public void alterarMorador(Morador obj) {
        try {
            //1 passo criar sql
            String sql = "update tb_morador set nome=?, cpf=?, email=?, celular=? where id_morador=?";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getCelular());
            
            stmt.setInt(5, obj.getId_morador());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo excluir morador
    public void excluirMorador(Morador obj) {
        try {
            //1 passo criar sql
            String sql = "delete from tb_morador where id_morador = ?";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId_morador());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo listar todo os clientes
    public List<Morador> listarMorador() {
        try {
            //1 passo criar a lista
            List<Morador> lista = new ArrayList<>();
            //2 passo criar o sql, organizar e executar
            String sql = "select * from tb_morador";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Morador obj = new Morador();
                obj.setId_morador(rs.getInt("id_morador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    //metodo consulta morador por nome
    public Morador consultarPorNome(String nome){
        try {
            //1 passo criar o sql, organizar e executar
            String sql = "select * from tb_morador where nome = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Morador obj = new Morador();
            if(rs.next()) {
                
                obj.setId_morador(rs.getInt("id_morador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Morador nao encontrado");
            return null;
        }
    }
    
    
    //metodo buscar cliente por nome
    public List<Morador> buscarMoradorPorNome(String nome) {
        try {
            //1 passo criar a lista
            List<Morador> lista = new ArrayList<>();
            //2 passo criar o sql, organizar e executar
            String sql = "select * from tb_morador where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Morador obj = new Morador();
                obj.setId_morador(rs.getInt("id_morador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCelular(rs.getString("celular"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    

}
