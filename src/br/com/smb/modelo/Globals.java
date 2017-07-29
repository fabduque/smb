package br.com.smb.modelo;

public class Globals {

	private static Globals instance;
	
	// Global variable
	private int idLogado;
	
	// Restrict the constructor from being instantiated
	private Globals(){}
	
	public void setIdLogado(int i) {
		this.idLogado = i;
	}
	
	public int GetIdLogado(){
		return this.idLogado;
	}
	
	public static synchronized Globals getInstance(){
		if (instance==null){
			instance=new Globals();
		}
		return instance;
	}
	
}
