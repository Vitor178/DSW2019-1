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
        
        
    public void insert(Promocao promocao) {
        String sql = "INSERT INTO Promocao (preco, nomePeca, dia, horario, id, cnpj) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, promocao.getPreco());
            statement.setString(2, promocao.getNomePeca());
            statement.setString(3, promocao.getDia());
            statement.setString(4, promocao.getHorario());
            statement.setInt(5, promocao.getId());
            statement.setInt(6, promocao.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public List<Promocao> getAll() {
        List<Promocao> listaPromocao = new ArrayList<>();
        String sql = "SELECT * FROM Promocao";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int preco = resultSet.getInt("preco");
                String nomePeca = resultSet.getString("nomePeca");
                String dia = resultSet.getString("dia");
                String horario = resultSet.getString("horario");
                Integer id = resultSet.getInt("id");          
                Integer cnpj = resultSet.getInt("cnpj");
                Promocao promocao = new Promocao(preco, nomePeca, dia, horario, id, cnpj);
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

    //modificar
    //precisa mudar a forma de remoção
    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao where cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(6, promocao.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET preco = ?, nomePeca = ?, dia = ?, horario = ?, id = ?, cnpj = ?";
        sql += " WHERE cnpj = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, promocao.getPreco());
            statement.setString(2, promocao.getNomePeca());
            statement.setString(3, promocao.getDia());
            statement.setString(4, promocao.getHorario());
            statement.setInt(5, promocao.getId());
            statement.setInt(6, promocao.getCnpj());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Promocao get(int cnpj, int id) {
        Promocao promocao = null;
        String sql = "SELECT * FROM Promocao WHERE cnpj = ? and id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(6, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int preco = resultSet.getInt("preco");
                String nomePeca = resultSet.getString("nomePeca");
                String dia = resultSet.getString("dia");
                String horario = resultSet.getString("horario");            
                promocao = new Promocao(preco, nomePeca, dia, horario,id, cnpj);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }    
}
