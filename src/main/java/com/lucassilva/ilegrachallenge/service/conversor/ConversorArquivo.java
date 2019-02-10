package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.lucassilva.ilegrachallenge.enums.TipoDadoEnum;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.service.file.DadoGerenciadorArquivo;
import com.lucassilva.ilegrachallenge.service.file.GerenciadorArquivo;

public class ConversorArquivo implements Conversor {

	private static final int BEGIN_PREFIX = 0;
	private static final int END_PREFIX = 3;

	public ConversorArquivo() {

	}

	@Override
	public List<String> lerArquivo(List<Path> arquivosCarregados) throws IOException {
		List<String> linhas = new ArrayList<String>();
		for (Path path : arquivosCarregados) {
			linhas.addAll(retornaDados(path));
		}
		return linhas;
	}

	private List<String> retornaDados(Path path) throws IOException {
		GerenciadorArquivo arquivo = new DadoGerenciadorArquivo(path);
		return arquivo.read();
	}

	@Override
	public DadoFaturamento converter(String data) {
		String codigo = data.substring(BEGIN_PREFIX, END_PREFIX);
		TipoDadoEnum tipoDadoEnum = TipoDadoEnum.get(codigo);
		return tipoDadoEnum.getConversorDado().convert(data);
	}

}
