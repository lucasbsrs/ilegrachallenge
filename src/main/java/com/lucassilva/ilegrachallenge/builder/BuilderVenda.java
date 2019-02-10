package com.lucassilva.ilegrachallenge.builder;

import java.util.List;

import com.lucassilva.ilegrachallenge.model.Item;
import com.lucassilva.ilegrachallenge.model.Venda;

public class BuilderVenda {

	private Venda venda;

	public BuilderVenda() {
		this.venda = new Venda();
	}
	
	public static BuilderVenda builder() {
        return new BuilderVenda();
    }
	
	public BuilderVenda idVenda(Long idVenda) {
        this.venda.setIdVenda(idVenda);
        return this;
    }
	
	public BuilderVenda itens(List<Item> itens) {
        this.venda.setListaItens(itens);
        return this;
    }
	
	public BuilderVenda vendedor(String vendedor) {
        this.venda.setVendedor(vendedor);
        return this;
    }
	
	public Venda get() {
        return this.venda;
    }
	

}
