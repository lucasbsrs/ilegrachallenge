package com.lucassilva.ilegrachallenge;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.config.ArquivoConfig;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;
import com.lucassilva.ilegrachallenge.service.file.DatFileManager;
import com.lucassilva.ilegrachallenge.service.file.FileManager;

public class ConversorTeste {

	@Test
	public void deveCarregarArquivoDeEntrada() throws IOException {
		FileManager fileManager = new DatFileManager(ArquivoConfig.PATH_ENTRADA);
		List<Path> arquivosCarregados = fileManager.retornaTodosArquivosDiretorio();

		Assert.assertEquals(true, !arquivosCarregados.isEmpty());
	}

	@Test
	public void deveLerArquivosDeEntrada() throws IOException {
		ConversorArquivo conversor = new ConversorArquivo();
		FileManager fileManager = new DatFileManager(ArquivoConfig.PATH_ENTRADA);
		List<Path> arquivosCarregados = fileManager.retornaTodosArquivosDiretorio();

		List<String> arquivosLidos = conversor.lerArquivo(arquivosCarregados);
		
		Assert.assertEquals(true, !arquivosLidos.isEmpty());
	}
	

}
