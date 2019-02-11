package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lucassilva.ilegrachallenge.enums.TipoDadoEnum;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.service.file.DadoGerenciadorArquivo;

@Service
public class ConversorArquivo implements Conversor {

	private static final int PREFIXO_INICIO = 0;
	private static final int PREFIXO_FIM = 3;

	public ConversorArquivo() {

	}

	@Override
	public List<DadoFaturamento> lerArquivo(File arquivo) {
		List<DadoFaturamento> linhasDoArquivo = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo));
			for (String line; (line = br.readLine()) != null;) {
				try {
					String prefixo = line.substring(PREFIXO_INICIO, PREFIXO_FIM);
					String[] linhasSplit = line.split(prefixo);
					for (String linha : linhasSplit) {
						if (!linha.isEmpty()) {
							DadoFaturamento linhaDadoFaturamento = converter(prefixo+linha);
							linhasDoArquivo.add(linhaDadoFaturamento);
						}
					}					
				} catch (Exception e) {
					System.out.println("Arquivo " + arquivo.getName() + " com erro: " + e.getMessage());
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Erro ao ler linha do arquivo do arquivo " + arquivo.getName());
		} catch (IOException e) {
			System.out.println("Erro ao ler linha do arquivo do arquivo " + arquivo.getName());
		}

		return linhasDoArquivo;
	}

	@Override
	public DadoFaturamento converter(String data) {
		String codigo = data.substring(PREFIXO_INICIO, PREFIXO_FIM);
		TipoDadoEnum tipoDadoEnum = TipoDadoEnum.get(codigo);
		DadoFaturamento dado = (DadoFaturamento) tipoDadoEnum.getConversorDado().convert(data);
		return dado;
	}
}
