package br.ufscar.dc.dsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CadastroDAO extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pw=request.getParameter("password");
		
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
                        
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:1527/test", "root", "root"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("select email,senha from Cadastro where email=? and senha=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("success.jsp");
			return;
		}
		response.sendRedirect("error.jsp");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}