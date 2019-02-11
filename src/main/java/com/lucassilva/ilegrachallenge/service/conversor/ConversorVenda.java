package com.lucassilva.ilegrachallenge.service.conversor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lucassilva.ilegrachallenge.builder.BuilderItem;
import com.lucassilva.ilegrachallenge.builder.BuilderVenda;
import com.lucassilva.ilegrachallenge.config.ArquivoPosicoesConfig;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.model.Item;
import com.lucassilva.ilegrachallenge.model.Venda;

public class ConversorVenda extends ConversorDado {

	private static final String SEPARADOR_ITENS_VENDA = ",";
	private static final String SEPARADOR_CAMPOS_ITENS_VENDA = "-";

	@Override
	public DadoFaturamento convert(String dado) {
		String[] campos = dado.split(SEPARADOR_DADOS);
		List<Item> listaItens = converterListaItens(campos[ArquivoPosicoesConfig.POSICAO_VENDA_ITENS]);
		Venda venda = BuilderVenda.builder().idVenda(Long.parseLong(campos[ArquivoPosicoesConfig.POSICAO_VENDA_ID]))
				.itens(listaItens).vendedor(campos[ArquivoPosicoesConfig.POSICAO_VENDA_VENDEDOR]).get();

		return venda;
	}

	private List<Item> converterListaItens(String itens) {
		List<Item> listaItens = new ArrayList<>();
		String[] arrItens = itens.substring(1, itens.length() - 1).split(SEPARADOR_ITENS_VENDA);

		Arrays.stream(arrItens).forEach(x -> { 
			Item item = converterItens(x);
			listaItens.add(item);
		});

		return listaItens;
	}

	private Item converterItens(String arrItens) {
		String[] camposItens = arrItens.split(SEPARADOR_CAMPOS_ITENS_VENDA);
		new BuilderItem();
		Item item = BuilderItem.builder()
				.idItem(Long.parseLong(camposItens[ArquivoPosicoesConfig.POSICAO_VENDA_ITEM_ID]))
				.quantidade(new Double(camposItens[ArquivoPosicoesConfig.POSICAO_VENDA_ITEM_QUANTIDADE]))
				.preco(new Double(camposItens[ArquivoPosicoesConfig.POSICAO_VENDA_ITEM_PRECO])).get();

		return item;

	}

}
