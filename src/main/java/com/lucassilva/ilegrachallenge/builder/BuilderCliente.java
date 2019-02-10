package com.lucassilva.ilegrachallenge.builder;

import com.lucassilva.ilegrachallenge.model.Cliente;

public class BuilderCliente {

	private Cliente cliente;

	public BuilderCliente() {
		this.cliente = new Cliente();
	}
	
	public static BuilderCliente builder() {
        return new BuilderCliente();
    }
	
	public BuilderCliente cnpj(String cnpj) {
        this.cliente.setCnpj(cnpj);
        return this;
    }
	
	public BuilderCliente nome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }
	
	public BuilderCliente areaNegocio(String areaNegocio) {
        this.cliente.setAreaNegocio(areaNegocio);
        return this;
    }
	
	public Cliente get() {
        return this.cliente;
    }
	

}
