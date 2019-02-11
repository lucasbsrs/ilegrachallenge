package com.lucassilva.ilegrachallenge.model;

import java.util.List;

public class Venda extends DadoFaturamento {

	private Long idVenda;
	private List<Item> listaItens;
	private String vendedor;

	public Venda() {

	}

	public Venda(Long idVenda, List<Item> listaItens, String vendedor) {
		super();
		this.idVenda = idVenda;
		this.listaItens = listaItens;
		this.vendedor = vendedor;
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public List<Item> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	public Double getValorPedido() {
		return listaItens.stream().mapToDouble(x -> x.getQuantidade() * x.getPreco()).sum();
	}

}
