package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Promocao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO {
	public PromocaoDAO() {	
	    try {
	   		Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
	        throw new RuntimeException(e);
	    }    
	}

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/DSW1", "root", "root");
    }
        
        
   public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cnpj = resultSet.getString("cnpj");
                float preco = resultSet.getFloat("preco");
                String nomePeca = resultSet.getString("nomePeca");
                String dia = resultSet.getString("dia");
                String horario = resultSet.getString("horario");            
                Promocao promocao = new Promocao(id, cnpj, preco, nomePeca, dia, horario);
                listaPromocao.add(promocao);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocao;
    }

    
    
}
