package com.lucassilva.ilegrachallenge.model;

public class Vendedor extends DadoFaturamento{

	private String cpf;
	private String nome;
	private Double salario;

	public Vendedor() {
		
	}
	
	public Vendedor(String cpf, String nome, Double salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
