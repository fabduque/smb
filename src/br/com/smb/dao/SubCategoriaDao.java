package br.com.smb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.smb.modelo.Globals;
import br.com.smb.modelo.SubCategoria;

@Repository
public class SubCategoriaDao {

	private final Connection connection;
	
	@Autowired
	public SubCategoriaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(SubCategoria subcategoria) {
			Globals g = Globals.getInstance();
			
			String sql = "insert into smbsub (dsSub, idCategoria, idUser) values (?,?,?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, subcategoria.getDsSub());
				stmt.setLong(2, subcategoria.getIdCategoria());
				stmt.setLong(3, g.GetIdLogado());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public List<SubCategoria> lista() {
		try {
			Globals g = Globals.getInstance();

			List<SubCategoria> subcategoria = new ArrayList<SubCategoria>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from smbsub where idUser=" + g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona o usuario na lista
				subcategoria.add(populaSub(rs));
			}

			rs.close();
			stmt.close();

			return subcategoria;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public SubCategoria buscaPorId(Long idSub) {

		try {
			Globals g = Globals.getInstance();

			PreparedStatement stmt = this.connection.prepareStatement("select * from smbsub where idSub = ? and idUser = ?");
			stmt.setLong(1, idSub);
			stmt.setInt(2, g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaSub(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

private SubCategoria populaSub(ResultSet rs) throws SQLException {
		SubCategoria subcategoria = new SubCategoria();

		// popula o objeto usuario
		subcategoria.setIdSub(rs.getLong("idSub"));
		subcategoria.setDsSub(rs.getString("dsSub"));
		subcategoria.setIdCategoria(rs.getLong("idCategoria"));
		subcategoria.setIdUser(rs.getLong("idUser"));
		
		return subcategoria;
	}

	public void altera(SubCategoria subcategoria) {
		Globals g = Globals.getInstance();

		String sql = "update smbsub set dsSub = ?, idCategoria = ? where idSub = ? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, subcategoria.getDsSub());
			stmt.setLong(2, subcategoria.getIdCategoria());
			stmt.setLong(3, subcategoria.getIdSub());
			stmt.setInt(4, g.GetIdLogado());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(SubCategoria subcategoria) {
		Globals g = Globals.getInstance();
		
		String sql = "delete from smbsub where idSub=? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, subcategoria.getIdSub());
			stmt.setInt(2, g.GetIdLogado());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
