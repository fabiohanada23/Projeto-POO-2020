package dao;
import factory.ConnectionFactory;
import modelo.morador;
import java.sql.*;
import java.sql.PreparedStatement;
public class moradorDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    public moradorDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(morador Morador){ 
        String sql = "INSERT INTO tbl_morador(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Morador.getNome());
            stmt.setString(2, Morador.getCpf());
            stmt.setString(3, Morador.getEmail());
            stmt.setString(4, Morador.getTelefone());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}
