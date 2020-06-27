package dao;
import factory.ConnectionFactory;
import modelo.prestador;
import java.sql.*;
import java.sql.PreparedStatement;
public class prestadorDAO { 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String ap_visita;
    String servico;
    public prestadorDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(prestador Prestador){ 
        String sql = "INSERT INTO tbl_prestador(nome,cpf,ap_visita,servico) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Prestador.getNome());
            stmt.setString(2, Prestador.getCpf());
            stmt.setString(3, Prestador.getAp_visita());
            stmt.setString(4, Prestador.getServico());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    } 
    
}

