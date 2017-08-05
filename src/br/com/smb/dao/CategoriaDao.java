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

import br.com.smb.modelo.Categoria;
import br.com.smb.modelo.Globals;

@Repository
public class CategoriaDao {

	private final Connection connection;
	
	@Autowired
	public CategoriaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Categoria categoria) {
			Globals g = Globals.getInstance();
			
			String sql = "insert into smbcategoria (dsCategoria, icDebCred, idUser) values (?,?,?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, categoria.getDsCategoria());
				stmt.setString(2, categoria.getIcDebCred());
				stmt.setLong(3, g.GetIdLogado());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public List<Categoria> lista() {
		try {
			Globals g = Globals.getInstance();

			List<Categoria> categoria = new ArrayList<Categoria>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from smbcategoria where idUser=" + g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona o usuario na lista
				categoria.add(populaCategoria(rs));
			}

			rs.close();
			stmt.close();

			return categoria;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Categoria buscaPorId(Long idCategoria) {

		try {
			Globals g = Globals.getInstance();

			PreparedStatement stmt = this.connection.prepareStatement("select * from smbcategoria where idCategoria = ? and idUser = ?");
			stmt.setLong(1, idCategoria);
			stmt.setInt(2, g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaCategoria(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

private Categoria populaCategoria(ResultSet rs) throws SQLException {
		Categoria categoria = new Categoria();

		// popula o objeto usuario
		categoria.setIdCategoria(rs.getLong("idCategoria"));
		categoria.setDsCategoria(rs.getString("dsCategoria"));
		categoria.setIcDebCred(rs.getString("icDebCred"));
		categoria.setIdUser(rs.getLong("idUser"));
		
		return categoria;
	}

	public void altera(Categoria categoria) {
		Globals g = Globals.getInstance();

		String sql = "update smbcategoria set dsCategoria = ?, icDebCred = ? where idCategoria = ? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, categoria.getDsCategoria());
			stmt.setString(2, categoria.getIcDebCred());
			stmt.setLong(3, categoria.getIdCategoria());
			stmt.setInt(4, g.GetIdLogado());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Categoria categoria) {
		Globals g = Globals.getInstance();
		
		String sql = "delete from smbcategoria where idCategoria=? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, categoria.getIdCategoria());
			stmt.setInt(2, g.GetIdLogado());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
