/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Corretor;
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
public class CorretorDAO {
    
    private Connection con;
    
    public CorretorDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //metodo cadastrar corretor
    public void cadastrarCorretor(Corretor obj){
        try {
            String sql="insert into tb_corretor (nome, cpf, ap_visita, num_registro) values (?, ?, ?, ?)";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getNum_registro());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }
    
    //metodo alterar corretor
    public void alterarCorretor(Corretor obj){
      try {
            //1 passo criar sql
            String sql = "update tb_corretor set nome=?, cpf=?, ap_visita=?, num_registro=? where id_corretor=?";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getNum_registro());
            
            stmt.setInt(5, obj.getId_corretor());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }  
    }
    
    //metodo excluir corretor
    public void excluirCorretor(Corretor obj){
        try {
            String sql="delete from tb_corretor where id_corretor =?";
            //2 passo conectar bd e organizar sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_corretor());
            //3 executar o comando sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }
    
    //metodo listar corretor
    public List<Corretor> listarCorretor(){
        try {
            //1 passo criar a lista
            List<Corretor> lista = new ArrayList();
            
            //2 passo criar oo comando sql, organizar e executar
            String sql = "select * from tb_corretor";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Corretor obj = new Corretor();
                
                obj.setId_corretor(rs.getInt("id_corretor"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setNum_registro(rs.getString("num_registro"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    //metodo consulta corretor por nome
    public Corretor consultarPorNome(String nome){
        try {
            //1 passo criar oo comando sql, organizar e executar
            String sql = "select * from tb_corretor where nome = ?";  
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
             Corretor obj = new Corretor(); 
            if(rs.next()){
                             
                obj.setId_corretor(rs.getInt("id_corretor"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setNum_registro(rs.getString("num_registro"));
            }
            return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Corretor nao encontrado");
            return null;
        }
    }
    
    //metodo buscar cliente por nome
    public List<Corretor> buscaCorretorPorNome(String nome){
        try {
            //1 passo criar a lista
            List<Corretor> lista = new ArrayList();
            
            //2 passo criar oo comando sql, organizar e executar
            String sql = "select * from tb_corretor where nome like ?";  
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Corretor obj = new Corretor();               
                obj.setId_corretor(rs.getInt("id_corretor"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setNum_registro(rs.getString("num_registro"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
}
