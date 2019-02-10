package com.lucassilva.ilegrachallenge.model;

public class Item {

	private Long idItem;
	private Double quantidade;
	private Double preco;

	public Item() {

	}

	public Item(Long idItem, Double quantidade, Double preco) {
		super();
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
