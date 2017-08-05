package br.com.smb.modelo;

import javax.validation.constraints.Size;

public class Categoria {

	private Long idCategoria;
	
	@Size(max=20, message="Máximo de 20 caracteres")
	private String dsCategoria;
	//	Debito ou Credito
	private String icDebCred;
	private Long idUser;
	
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDsCategoria() {
		return dsCategoria;
	}
	public void setDsCategoria(String dsCategoria) {
		this.dsCategoria = dsCategoria;
	}
	public String getIcDebCred() {
		return icDebCred;
	}
	public void setIcDebCred(String icDebCred) {
		this.icDebCred = icDebCred;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	@Override
	public String toString() {
		return this.dsCategoria;
	}
}
