package br.com.smb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.smb.modelo.Usuario;

@Repository
public class UsuarioDao {

	private final Connection connection;
	
	@Autowired
	public UsuarioDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Usuario usuario) {
			String sql = "insert into smb_usuario (nome, nick, email, senha, dtNasc, status) values (?,?,?,?,?,?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getNick());
				stmt.setString(3, usuario.getEmail());
				stmt.setString(4, usuario.getSenha());
				//stmt.setString(6, usuario.getCpf());
				//stmt.setString(7, usuario.getTelefone());
				stmt.setDate(5, usuario.getDtNasc() != null ? new Date(usuario.getDtNasc().getTimeInMillis()):null);
				stmt.setString(6, " ");
				//stmt.setString(9, usuario.getImagem());
				//stmt.setString(10, usuario.getTp_user());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public List<Usuario> lista() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from smb_usuario");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona o usuario na lista
				usuarios.add(populaUsuario(rs));
			}

			rs.close();
			stmt.close();

			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Usuario buscaPorId(Long id_user) {

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from smb_usuario where id_user = ?");
			stmt.setLong(1, id_user);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaUsuario(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

private Usuario populaUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();

		// popula o objeto usuario
		usuario.setId_user(rs.getLong("id_user"));
		usuario.setNome(rs.getString("nome"));
		usuario.setNick(rs.getString("nick"));
		usuario.setEmail(rs.getString("email"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setStatus(rs.getString("status"));

		// popula a data de nascimento, fazendo a conversao
		Date data = rs.getDate("dtNasc");
		if (data != null) {
			Calendar dtNasc = Calendar.getInstance();
			dtNasc.setTime(data);
			usuario.setDtNasc(dtNasc);
		}
		return usuario;
	}

	public void altera(Usuario usuario) {
		String sql = "update smb_usuario set nome = ?, nick = ?, email = ?, senha = ?, dtNasc = ? where id_user = ?";
		//String sql = "update smb_usuario set nome = ?, nick = ?, email = ?, senha = ? where id_user = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getNick());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getSenha());
			stmt.setDate(5, usuario.getDtNasc() != null ? new Date(usuario.getDtNasc().getTimeInMillis()):null);
			//stmt.setDate(5, new java.sql.Date(usuario.getDtNasc().getTimeInMillis()));
			stmt.setLong(6, usuario.getId_user());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Usuario usuario) {

		String sql = "delete from smb_usuario where id_user=?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, usuario.getId_user());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
