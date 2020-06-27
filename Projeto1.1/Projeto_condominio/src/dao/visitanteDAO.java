package dao;
import factory.ConnectionFactory;
import modelo.Visitante;
import java.sql.*;
import java.sql.PreparedStatement;
public class visitanteDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    public visitanteDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Visitante visitante){ 
        String sql = "INSERT INTO tbl_visitante(nome,cpf,ap_visita) VALUES(?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, visitante.getNome());
            stmt.setString(2, visitante.getCpf());
            stmt.setString(3, visitante.getAp_visita());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}
