package com.lucassilva.ilegrachallenge.builder;

import com.lucassilva.ilegrachallenge.model.Vendedor;

public class BuilderVendedor {

	private Vendedor vendedor;
	
	public BuilderVendedor() {
		this.vendedor = new Vendedor();
	}
	
	public static BuilderVendedor builder() {
        return new BuilderVendedor();
    }
	
	public BuilderVendedor cpf(String cpf) {
        this.vendedor.setCpf(cpf);
        return this;
    }
	
	public BuilderVendedor nome(String nome) {
        this.vendedor.setNome(nome);
        return this;
    }
	
	public BuilderVendedor salario(Double salario) {
        this.vendedor.setSalario(salario);
        return this;
    }
	
	public Vendedor get() {
        return this.vendedor;
    }
	
}
