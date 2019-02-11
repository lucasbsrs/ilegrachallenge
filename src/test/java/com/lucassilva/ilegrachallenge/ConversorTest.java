package com.lucassilva.ilegrachallenge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.config.ArquivoConfig;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;
import com.lucassilva.ilegrachallenge.util.ArquivoUtil;

public class ConversorTest {

	@Test
	public void deveCarregarArquivoDeEntrada() throws IOException {
		ArquivoUtil gerenciadorArquivos = new ArquivoUtil();
		List<File> arquivosCarregados = gerenciadorArquivos.listarArquivosDoDiretorio(ArquivoConfig.PATH_ENTRADA);

		Assert.assertEquals(true, !arquivosCarregados.isEmpty());
	}

	@Test
	public void deveLerArquivosDeEntrada() throws IOException {
		ConversorArquivo conversor = new ConversorArquivo();
		ArquivoUtil gerenciadorArquivos = new ArquivoUtil();

		List<File> arquivosCarregados = gerenciadorArquivos.listarArquivosDoDiretorio(ArquivoConfig.PATH_ENTRADA);

		arquivosCarregados.forEach(arquivo -> {
			List<DadoFaturamento> arquivosLidos = new ArrayList<>();
			arquivosLidos = conversor.lerArquivo(arquivo);

			Assert.assertEquals(true, !arquivosLidos.isEmpty());
		});

	}

}
