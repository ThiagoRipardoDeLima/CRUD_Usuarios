package br.com.usuariocrud.model;
/*
 * classe retorna o resultado da API
 */
public class ResponseModel {

	private int codigo;
	private String mensagem;
	
	//Constructors
	public ResponseModel() {}
	
	public ResponseModel(int codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}
	
	//Getters and Setters
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
