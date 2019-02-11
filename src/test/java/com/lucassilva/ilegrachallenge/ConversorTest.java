package com.lucassilva.ilegrachallenge;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.config.ArquivoConfig;
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
//		ConversorArquivo conversor = new ConversorArquivo();
//		ArquivoUtil gerenciadorArquivos = new ArquivoUtil();
//		List<File> arquivosCarregados = gerenciadorArquivos.listarArquivosDoDiretorio(ArquivoConfig.PATH_ENTRADA);
//
//		List<String> arquivosLidos = conversor.lerArquivo(arquivosCarregados);
//
//		Assert.assertEquals(true, !arquivosLidos.isEmpty());
	}

}
