package dao;
import factory.ConnectionFactory;
import modelo.corretor;
import java.sql.*;
import java.sql.PreparedStatement;
public class corretorDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    String num_registro;
    public corretorDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(corretor Corretor){ 
        String sql = "INSERT INTO tbl_corretor(nome,cpf,ap_visita,num_registro) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Corretor.getNome());
            stmt.setString(2, Corretor.getCpf());
            stmt.setString(3, Corretor.getAp_visita());
            stmt.setString(4, Corretor.getNum_registro());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}