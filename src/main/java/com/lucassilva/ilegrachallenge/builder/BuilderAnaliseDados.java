package com.lucassilva.ilegrachallenge.builder;

import com.lucassilva.ilegrachallenge.model.AnaliseDados;
import com.lucassilva.ilegrachallenge.model.Vendedor;

public class BuilderAnaliseDados {

	private AnaliseDados analiseDados;
	
	public BuilderAnaliseDados() {
		this.analiseDados = new AnaliseDados();
	}
	
	public static BuilderAnaliseDados builder() {
        return new BuilderAnaliseDados();
    }
	
	public BuilderAnaliseDados totalClientes(Long totalClientes) {
        this.analiseDados.setTotalClientes(totalClientes);
        return this;
    }
	
	public BuilderAnaliseDados totalVendedores(Long totalVendedores) {
        this.analiseDados.setTotalVendedores(totalVendedores);
        return this;
    }
	
	public BuilderAnaliseDados idVendaMaisCara(Long idVendaMaisCara) {
        this.analiseDados.setIdVendaMaisCara(idVendaMaisCara);
        return this;
    }
	
	public BuilderAnaliseDados vendedorComMenosVendas(Vendedor vendedorComMenosVendas) {
        this.analiseDados.setVendedorComMenosVendas(vendedorComMenosVendas);
        return this;
    }
	
	public AnaliseDados get() {
        return this.analiseDados;
    }
	

}
