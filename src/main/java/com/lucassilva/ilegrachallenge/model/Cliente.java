package com.lucassilva.ilegrachallenge.model;

public class Cliente extends DadoFaturamento {

	private String cnpj;
	private String nome;
	private String areaNegocio;

	public Cliente() {
		
	}
	
	public Cliente(String cnpj, String nome, String areaNegocio) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.areaNegocio = areaNegocio;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaNegocio() {
		return areaNegocio;
	}

	public void setAreaNegocio(String areaNegocio) {
		this.areaNegocio = areaNegocio;
	}

}
