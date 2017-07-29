package br.com.smb.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.smb.jdbc.ConnectionFactory;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao Aberta!");
		connection.close();
	}
	
}
