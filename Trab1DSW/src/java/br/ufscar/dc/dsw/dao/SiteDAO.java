package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.model.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO {

    public SiteDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/DSW1", "root", "root");
    }

    public void insert(Site site) {
        String sql = "INSERT INTO Site (id, email, senha, url, nome, telefone) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, site.getId());
            statement.setString(2, site.getEmail());
            statement.setString(3, site.getSenha());
            statement.setString(4, site.getUrl());
            statement.setString(5, site.getNome());
            statement.setString(6, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Site> getAll() {
        List<Site> listaSite = new ArrayList<>();
        String sql = "SELECT * FROM Site";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");                
                Site site = new Site(id, email, senha, url, nome, telefone);
                listaSite.add(site);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSite;
    }

    public void delete(Site site) {
        String sql = "DELETE FROM Site where id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, site.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Site site) {
        String sql = "UPDATE Site SET email = ?, senha = ?, url = ?, nome = ?, nome = ?, telefone = ?";
        sql += " WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(2, site.getEmail());
            statement.setString(3, site.getSenha());
            statement.setString(4, site.getUrl());
            statement.setString(5, site.getNome());
            statement.setString(6, site.getTelefone());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Site get(int id) {
        Site site = null;
        String sql = "SELECT * FROM Site WHERE id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String url = resultSet.getString("url");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone"); 
                site = new Site(id, email, senha, url, nome, telefone);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}
