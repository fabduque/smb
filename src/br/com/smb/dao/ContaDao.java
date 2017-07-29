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

import br.com.smb.modelo.Conta;
import br.com.smb.modelo.Globals;

@Repository
public class ContaDao {

	private final Connection connection;
	
	@Autowired
	public ContaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void adiciona(Conta conta) {
			Globals g = Globals.getInstance();
			
			String sql = "insert into smbconta (dsConta, tpConta, vlSaldoinicial, dsObs, idUser) values (?,?,?,?,?)";
			PreparedStatement stmt;
			try {
				stmt = connection.prepareStatement(sql);
				stmt.setString(1, conta.getDsConta());
				stmt.setString(2, conta.getTpConta());
				stmt.setFloat(3, conta.getVlSaldoInicial());
				stmt.setString(4, conta.getDsObs());
				stmt.setLong(5, g.GetIdLogado());
				stmt.execute();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public List<Conta> lista() {
		try {
			Globals g = Globals.getInstance();

			List<Conta> conta = new ArrayList<Conta>();
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from smbconta where idUser=" + g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// adiciona a conta na lista
				conta.add(populaConta(rs));
			}

			rs.close();
			stmt.close();

			return conta;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Conta buscaPorId(Long idConta) {

		try {
			Globals g = Globals.getInstance();

			PreparedStatement stmt = this.connection.prepareStatement("select * from smbconta where idConta = ? and idUser = ?");
			stmt.setLong(1, idConta);
			stmt.setInt(2, g.GetIdLogado());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return populaConta(rs);
			}

			rs.close();
			stmt.close();

			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

private Conta populaConta(ResultSet rs) throws SQLException {
		Conta conta= new Conta();

		// popula o objeto usuario
		conta.setIdConta(rs.getLong("idConta"));
		conta.setDsConta(rs.getString("dsConta"));
		conta.setTpConta(rs.getString("tpConta"));
		conta.setVlSaldoInicial(rs.getFloat("vlSaldoInicial"));
		conta.setDsObs(rs.getString("dsObs"));
		conta.setIdUser(rs.getLong("idUser"));
		
		return conta;
	}

	public void altera(Conta conta) {
		Globals g = Globals.getInstance();

		String sql = "update smbconta set dsConta = ?, tpConta = ?, vlSaldoInicial = ?, dsObs = ? where idConta = ? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, conta.getDsConta());
			stmt.setString(2, conta.getTpConta());
			stmt.setFloat(3, conta.getVlSaldoInicial());
			stmt.setString(4, conta.getDsObs());
			stmt.setLong(5, conta.getIdConta());
			stmt.setInt(6, g.GetIdLogado());
			
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void exclui(Conta conta) {
		Globals g = Globals.getInstance();
		
		String sql = "delete from smbconta where idConta=? and idUser = ?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, conta.getIdConta());
			stmt.setInt(2, g.GetIdLogado());
			stmt.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
