package br.com.smb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.smb.jdbc.ConnectionFactory;
import br.com.smb.modelo.Globals;
import br.com.smb.modelo.Login;

public class LoginDao {
	
	private final Connection connection;

	public LoginDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Integer existeUsuario(Login login) {
		
		int retorno;
		
		Globals g = Globals.getInstance();
		
		String sql = "select * from smb_usuario where nick = ? and senha = ?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, login.getLogin());
			stmt.setString(2, login.getSenha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()){
				g.setIdLogado(rs.getInt("id_user"));
				retorno = rs.getInt("id_user");				
			}else
				retorno = 0;
			
			rs.close();
			stmt.close();
			
			return retorno;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
