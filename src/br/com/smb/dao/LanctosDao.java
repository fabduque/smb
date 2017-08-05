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
import br.com.smb.modelo.Lanctos;

@Repository
public class LanctosDao {

	private final Connection connection;
	
	@Autowired
	public LanctosDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Lanctos lanctos) {
			Globals g = Globals.getInstance();
			
			String sql = "insert into smblancamento "
					+ "(idConta, idCategoria, idSubCategoria, idForma, idUser, tpConta, dsLancamento, sgStatus, sgMovimento, "
					+ "vlLancamento, icContaFixa, dsFaturaCartao) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setLong(1, lanctos.getIdConta());
				stmt.setLong(2, lanctos.getIdCategoria());
				stmt.setLong(3, lanctos.getIdSubCategoria());
				stmt.setLong(4, lanctos.getIdForma());
				stmt.setLong(5, g.GetIdLogado());
				stmt.setLong(6, lanctos.getTpConta());
//				stmt.setDate(7, lanctos.getDtLancamento() != null ? new Date(lancto.getDtLancamento().getTimeInMillis()):null);
				stmt.setString(7, lanctos.getDsLancamento());
				stmt.setString(8, lanctos.getSgStatus());
				stmt.setString(9, lanctos.getSgMovimento());
				stmt.setFloat(10, lanctos.getVlLancamento());
				stmt.setString(11, lanctos.getIcContaFixa());
				stmt.setString(12, lanctos.getDsFaturaCartao());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public List<Lanctos> lista() {
		try {
			Globals g = Globals.getInstance();

			List<Lanctos> lanctos = new ArrayList<Lanctos>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from smblancamento where idUser=" + g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a conta na lista
				lanctos.add(populaLancto(rs));
			}

			rs.close();
			stmt.close();

			return lanctos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Lanctos buscaPorId(Long idLancamento) {

		try {
			Globals g = Globals.getInstance();

			PreparedStatement stmt = this.connection.prepareStatement("select * from smblancamento where idLancamento = ? and idUser = ?");
			stmt.setLong(1, idLancamento);
			stmt.setInt(2, g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaLancto(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

private Lanctos populaLancto(ResultSet rs) throws SQLException {
		Lanctos lanctos= new Lanctos();

		// popula o objeto usuario
		lanctos.setIdLancamento(rs.getLong("idLancamento"));
		lanctos.setIdConta(rs.getLong("idConta"));
		lanctos.setIdCategoria(rs.getLong("idCategoria"));			
		lanctos.setIdForma(rs.getLong("idForma"));
		lanctos.setIdUser(rs.getLong("idUser"));			
		lanctos.setTpConta(rs.getLong("tpConta"));			
//		// popula a data de nascimento, fazendo a conversao
//		Date data = rs.getDate("dtLancamento");
//		
//		if (data != null) {
//			Calendar dtLancamento = Calendar.getInstance();
//			dtLancamento.setTime(data);
//			lanctos.setDtLancamento(dtLancamento);
//		}
		lanctos.setDsLancamento(rs.getString("dsLancamento"));			
		lanctos.setSgStatus(rs.getString("sgStatus"));	
		lanctos.setVlLancamento(rs.getFloat("vlLancamento"));	
		lanctos.setIcContaFixa(rs.getString("icContaFixa"));	
		lanctos.setDsFaturaCartao(rs.getString("dsFaturaCartao"));	
		
		return lanctos;
	}

	public void altera(Lanctos lanctos) {
		Globals g = Globals.getInstance();

		String sql = "update smblancamento set dsLancamento = ?, tpConta = ?, vlLancamento = ? where idLancamento = ? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, lanctos.getDsLancamento());
			stmt.setLong(2, lanctos.getTpConta());
			stmt.setFloat(3, lanctos.getVlLancamento());
			stmt.setLong(4, lanctos.getIdConta());
			stmt.setInt(5, g.GetIdLogado());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Lanctos lanctos) {
		Globals g = Globals.getInstance();
		
		String sql = "delete from smblancamento where idLancamento=? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, lanctos.getIdLancamento());
			stmt.setInt(2, g.GetIdLogado());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
