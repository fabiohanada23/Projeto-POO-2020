/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Entregador;
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
public class EntregadorDAO {

    private Connection con;

    public EntregadorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //metodo cadastrar entregador
    public void cadastrarEntregador(Entregador obj) {
        try {
            //1 passo criar o comando sql
            String sql = "insert into tb_entregador (nome, cpf, ap_visita, tipo_entrega) values (?, ?, ?, ?)";
            //2 passo conectar ao bd e organizar
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getTipo_entrega());
            //3 executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }
    }

    //metodo alterar entregador
    public void alterarEntregador(Entregador obj) {
        try {
            //1 passo criar o comando sql
            String sql = "update tb_entregador set nome=?, cpf=?, ap_visita=?, tipo_entrega=? where id_entregador=?";
            //2 passo conectar ao bd e organizar
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getAp_visita());
            stmt.setString(4, obj.getTipo_entrega());
            stmt.setInt(5, obj.getId_entregador());
            //3 executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado");
            
           
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    //metodo excluir entregador
    public void excluirEntregador(Entregador obj) {
        try {
            //1 passo criar o comando sql
            String sql = "delete from tb_entregador where id_entregador =?";
            //2 passo conectar ao bd e organizar
            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setInt(1, obj.getId_entregador());
            
            //3 executar
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    //metodo listar entregador
    public List<Entregador> listarEntregador() {
        try {
            //1 passo criar a lista
            List<Entregador> lista = new ArrayList<>();
            //2 passo criar, organizar e executar sql
            String sql = "select * from tb_entregador";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Entregador obj = new Entregador();
                obj.setId_entregador(rs.getInt("id_entregador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_entrega(rs.getString("tipo_entrega"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    //metodo consulta pode nome
    public Entregador consultaPorNome(String nome){
        try {
            //1 passo criar, organizar e executar sql
            String sql = "select * from tb_entregador where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            Entregador obj = new Entregador();
             if(rs.next()) {
                
                obj.setId_entregador(rs.getInt("id_entregador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_entrega(rs.getString("tipo_entrega"));

               
            }
             return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entregador nao encontrado");
            return null;
        }
    }
    
    //metodo buscar entregador por nome
    public List<Entregador> buscaClientePorEntregador(String nome) {
        try {
            //1 passo criar a lista
            List<Entregador> lista = new ArrayList<>();
            //2 passo criar, organizar e executar sql
            String sql = "select * from tb_entregador where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Entregador obj = new Entregador();
                obj.setId_entregador(rs.getInt("id_entregador"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setAp_visita(rs.getString("ap_visita"));
                obj.setTipo_entrega(rs.getString("tipo_entrega"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
    }
    
    

}
