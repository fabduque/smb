package br.com.smb.modelo;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {

	private Long id_user;
	
	@Size(min=10, message="Minimo de 10 caracteres")
	private String nome;
	private String nick;
	private String email;
	private String senha;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dtNasc;
	private String status;
	
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Calendar getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Calendar dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getStatus() {
		return email;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
