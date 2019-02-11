package com.lucassilva.ilegrachallenge.model;

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

	public String getLinhasAnalise() {
		StringBuilder analise = new StringBuilder();
		analise.append("Total Clientes: " + this.totalClientes);
		analise.append("\n");
		analise.append("Total Vendedores: " + this.totalVendedores);
		analise.append("\n");
		analise.append("ID Venda mais cara: " + this.idVendaMaisCara);
		analise.append("\n");
		analise.append("Vendedor com menor venda: " + this.vendedorComMenosVendas.getNome());
		return analise.toString();
	}

}
