package br.com.smb.modelo;

import javax.validation.constraints.Size;

public class Conta {
	private Long idConta;
	
	@Size(max=20, message="Máximo de 20 caracteres")
	private String dsConta;
	private String tpConta;
	private Float vlSaldoInicial;
	private String dsObs;
	private Long idUser;
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public String getDsConta() {
		return dsConta;
	}
	public void setDsConta(String dsConta) {
		this.dsConta = dsConta;
	}
	public String getTpConta() {
		return tpConta;
	}
	public void setTpConta(String tpConta) {
		this.tpConta = tpConta;
	}
	public Float getVlSaldoInicial() {
		return vlSaldoInicial;
	}
	public void setVlSaldoInicial(Float vlSaldoInicial) {
		this.vlSaldoInicial = vlSaldoInicial;
	}
	public String getDsObs() {
		return dsObs;
	}
	public void setDsObs(String dsObs) {
		this.dsObs = dsObs;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
}
