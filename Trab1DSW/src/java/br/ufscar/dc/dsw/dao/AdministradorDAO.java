package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Administrador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO {
	public AdministradorDAO() {	
	    try {
	   		Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
	        throw new RuntimeException(e);
	    }    
	}

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/DSW1", "root", "root");
    }
        
        
    public void insert(Administrador administrador) {
        String sql = "INSERT INTO Admin (cpf, prenome, sobrenome, email, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, administrador.getCpf());
            statement.setString(2, administrador.getPrenome());
            statement.setString(3, administrador.getSobrenome());
            statement.setString(4, administrador.getEmail());
            statement.setString(5, administrador.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Administrador administrador) {
        String sql = "DELETE FROM Promocao where cpf = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, administrador.getCpf());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Administrador administrador) {
        String sql = "UPDATE Promocao SET  cpf = ?, prenome = ?, sobrenome = ?, email = ?, senha = ?";
        sql += " WHERE cpf = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, administrador.getCpf());
            statement.setString(2, administrador.getPrenome());
            statement.setString(3, administrador.getSobrenome());
            statement.setString(4, administrador.getEmail());
            statement.setString(5, administrador.getSenha());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Administrador get(int cpf) {
        Administrador administrador = null;
        String sql = "SELECT * FROM Promocao WHERE cpf = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String prenome = resultSet.getString("prenome");
                String sobrenome = resultSet.getString("sobrenome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");            
                administrador = new Administrador(cpf,prenome, sobrenome, email, senha);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return administrador;
    }    
}
