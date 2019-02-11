package com.lucassilva.ilegrachallenge.model;

import java.util.ArrayList;
import java.util.List;

import com.lucassilva.ilegrachallenge.service.conversor.ConversorDado;

public class AnaliseDados {

	private Long totalClientes;
	private Long totalVendedores;
	private Long idVendaMaisCara;
	private Vendedor vendedorComMenosVendas;

	public Long getTotalClientes() {
		return totalClientes;
	}

	public void setTotalClientes(Long totalClientes) {
		this.totalClientes = totalClientes;
	}

	public Long getTotalVendedores() {
		return totalVendedores;
	}

	public void setTotalVendedores(Long totalVendedores) {
		this.totalVendedores = totalVendedores;
	}

	public Long getIdVendaMaisCara() {
		return idVendaMaisCara;
	}

	public void setIdVendaMaisCara(Long idVendaMaisCara) {
		this.idVendaMaisCara = idVendaMaisCara;
	}

	public Vendedor getVendedorComMenosVendas() {
		return vendedorComMenosVendas;
	}

	public void setVendedorComMenosVendas(Vendedor vendedorComMenosVendas) {
		this.vendedorComMenosVendas = vendedorComMenosVendas;
	}

	public List<String> getLinhasAnalise() {
		List<String> lines = new ArrayList<>();
		lines.add("Total Clientes: " + this.totalClientes);
		lines.add("Total Vendedores: " + this.totalVendedores);
		lines.add("ID Venda mais cara: " + this.idVendaMaisCara);
		lines.add("Vendedor com menor venda: " + this.vendedorComMenosVendas.getNome());
		return lines;
	}
	
	

}
