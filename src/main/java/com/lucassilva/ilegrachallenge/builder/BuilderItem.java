package com.lucassilva.ilegrachallenge.builder;

import com.lucassilva.ilegrachallenge.model.Item;

public class BuilderItem {

	private Item item;

	public BuilderItem() {
		this.item = new Item();
	}
	
	public static BuilderItem builder() {
        return new BuilderItem();
    }
	
	public BuilderItem idItem(Long idItem) {
        this.item.setIdItem(idItem);
        return this;
    }
	
	public BuilderItem quantidade(Double quantidade) {
        this.item.setQuantidade(quantidade);
        return this;
    }
	
	public BuilderItem preco(Double preco) {
        this.item.setPreco(preco);
        return this;
    }
	
	public Item get() {
        return this.item;
    }
	

}
