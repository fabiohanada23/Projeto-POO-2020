package dao;
import factory.ConnectionFactory;
import modelo.entrega;
import java.sql.*;
import java.sql.PreparedStatement;
public class entregaDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    String entrega;
    public entregaDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(entrega Entrega){ 
        String sql = "INSERT INTO tbl_entrega(nome,cpf,ap_visita,entrega) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Entrega.getNome());
            stmt.setString(2, Entrega.getCpf());
            stmt.setString(3, Entrega.getAp_visita());
            stmt.setString(4, Entrega.getEntrega());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}
