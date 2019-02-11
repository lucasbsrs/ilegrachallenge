package com.lucassilva.ilegrachallenge;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.builder.BuilderItem;
import com.lucassilva.ilegrachallenge.model.Item;
import com.lucassilva.ilegrachallenge.model.Venda;
import com.lucassilva.ilegrachallenge.service.conversor.Conversor;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;

public class ConversorVendaTest {

	@Test
	public void deveConverterVenda() {
		Conversor conversor = new ConversorArquivo();
		List<Item> itens = new ArrayList<>();
		Venda venda = (Venda) conversor.converter("003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
		Assert.assertEquals(10, venda.getIdVenda().longValue());
		Assert.assertEquals("Diego", venda.getVendedor());
		Item item1 = BuilderItem.builder().idItem(1L).quantidade(10.0).preco(100.0).get();
		Item item2 = BuilderItem.builder().idItem(2L).quantidade(30.0).preco(2.50).get();
		Item item3 = BuilderItem.builder().idItem(3L).quantidade(40.0).preco(3.10).get();
		itens.add(item1);
		itens.add(item2);
		itens.add(item3);

		for (Item item : itens) {
			Assert.assertTrue(venda.getListaItens().stream().anyMatch(x -> x.getIdItem().equals(item.getIdItem())
					&& x.getPreco().equals(item.getPreco()) && x.getQuantidade().equals(item.getQuantidade())));
		}
	}
}
