package br.com.smb.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Lanctos {

	private Long idLancamento;
	private Long idConta;
	private Long idCategoria;
	private Long idSubCategoria;
	private Long idForma;
	private Long idUser;
	private Long tpConta;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dtLancamento; 
	private String dsLancamento;
	private String sgStatus;
	private String sgMovimento;
	private Float vlLancamento;
	private String icContaFixa;
	private String dsFaturaCartao;
	public Long getIdLancamento() {
		return idLancamento;
	}
	public void setIdLancamento(Long idLancamento) {
		this.idLancamento = idLancamento;
	}
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdSubCategoria() {
		return idSubCategoria;
	}
	public void setIdSubCategoria(Long idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}
	public Long getIdForma() {
		return idForma;
	}
	public void setIdForma(Long idForma) {
		this.idForma = idForma;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Long getTpConta() {
		return tpConta;
	}
	public void setTpConta(Long tpConta) {
		this.tpConta = tpConta;
	}
	public Calendar getDtLancamento() {
		return dtLancamento;
	}
	public void setDtLancamento(Calendar dtLancamento) {
		this.dtLancamento = dtLancamento;
	}
	public String getDsLancamento() {
		return dsLancamento;
	}
	public void setDsLancamento(String dsLancamento) {
		this.dsLancamento = dsLancamento;
	}
	public String getSgStatus() {
		return sgStatus;
	}
	public void setSgStatus(String sgStatus) {
		this.sgStatus = sgStatus;
	}
	public String getSgMovimento() {
		return sgMovimento;
	}
	public void setSgMovimento(String sgMovimento) {
		this.sgMovimento = sgMovimento;
	}
	public Float getVlLancamento() {
		return vlLancamento;
	}
	public void setVlLancamento(Float vlLancamento) {
		this.vlLancamento = vlLancamento;
	}
	public String getIcContaFixa() {
		return icContaFixa;
	}
	public void setIcContaFixa(String icContaFixa) {
		this.icContaFixa = icContaFixa;
	}
	public String getDsFaturaCartao() {
		return dsFaturaCartao;
	}
	public void setDsFaturaCartao(String dsFaturaCartao) {
		this.dsFaturaCartao = dsFaturaCartao;
	}

	
}
