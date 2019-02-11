package com.lucassilva.ilegrachallenge.service.conversor;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucassilva.ilegrachallenge.builder.BuilderAnaliseDados;
import com.lucassilva.ilegrachallenge.model.AnaliseDados;
import com.lucassilva.ilegrachallenge.model.Cliente;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.model.Venda;
import com.lucassilva.ilegrachallenge.model.Vendedor;

@Service
public class AnaliseDadosService {

	public AnaliseDados analisar(List<DadoFaturamento> linhasArquivo) {
		Long totalCliente = getTotalClientes(linhasArquivo);
		Long totalVendedores = getTotalVendedores(linhasArquivo);
		Long vendaMaisCara = getVendaMaisCara(linhasArquivo);
		Vendedor vendedorComMenosVendas = getVendedorComMenosVendas(linhasArquivo);

		AnaliseDados analiseDados = BuilderAnaliseDados.builder().totalClientes(totalCliente)
				.totalVendedores(totalVendedores).idVendaMaisCara(vendaMaisCara)
				.vendedorComMenosVendas(vendedorComMenosVendas).get();

		return analiseDados;
	}

	private long getTotalVendedores(List<DadoFaturamento> linhasArquivo) {
		return linhasArquivo.stream().filter(Vendedor.class::isInstance).count();
	}

	private long getTotalClientes(List<DadoFaturamento> linhasArquivo) {
		return linhasArquivo.stream().filter(Cliente.class::isInstance).count();
	}

	private Long getVendaMaisCara(List<DadoFaturamento> linhasDoArquivoNormalizadas) {
		List<Venda> vendas = getVendas(linhasDoArquivoNormalizadas);

		if (vendas.isEmpty())
			return 0L;

		return Collections.max(vendas, Comparator.comparing(Venda::getValorPedido)).getIdVenda();
	}

	private List<Venda> getVendas(List<DadoFaturamento> linhasDoArquivoNormalizadas) {
		return linhasDoArquivoNormalizadas.stream().filter(Venda.class::isInstance).map(venda -> (Venda) venda)
				.collect(Collectors.toList());
	}

	private Vendedor getVendedorComMenosVendas(List<DadoFaturamento> linhasDoArquivoNormalizadas) {
		List<Vendedor> vendedores = getVendedores(linhasDoArquivoNormalizadas);

		List<Venda> vendas = getVendas(linhasDoArquivoNormalizadas);

		Map<Vendedor, Double> relacaoDeVendasPorVendedor = new HashMap<>();

		vendedores.forEach(vendedor -> {
			List<Venda> vendasDoVendedor = vendas.stream().filter(venda -> venda.getVendedor().equals(vendedor.getNome()))
					.collect(Collectors.toList());

			Double totalVendas = vendasDoVendedor.stream().mapToDouble(Venda::getValorPedido).sum();

			relacaoDeVendasPorVendedor.put(vendedor, totalVendas);
		});

		return Collections.min(relacaoDeVendasPorVendedor.entrySet(), Comparator.comparing(Entry::getValue)).getKey();
	}

	private List<Vendedor> getVendedores(List<DadoFaturamento> linhasDoArquivoNormalizadas) {
		return linhasDoArquivoNormalizadas.stream().filter(Vendedor.class::isInstance).map(vendedor -> (Vendedor) vendedor)
				.collect(Collectors.toList());
	}

}
