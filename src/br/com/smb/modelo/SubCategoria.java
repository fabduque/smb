package br.com.smb.modelo;

import javax.validation.constraints.Size;

import br.com.smb.dao.CategoriaDao;

public class SubCategoria {

	private Long idSub;
	
	@Size(max=20, message="Máximo de 20 caracteres")
	private String dsSub;
	private Long idCategoria;
	private Long idUser;
	
	public Long getIdSub() {
		return idSub;
	}
	public void setIdSub(Long idSub) {
		this.idSub = idSub;
	}
	public String getDsSub() {
		return dsSub;
	}
	public void setDsSub(String dsSub) {
		this.dsSub = dsSub;
	}
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public void descCategoria(){
		
		
	}
}
