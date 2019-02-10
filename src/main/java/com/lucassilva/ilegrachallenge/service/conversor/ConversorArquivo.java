package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.lucassilva.ilegrachallenge.service.file.DatFileManager;
import com.lucassilva.ilegrachallenge.service.file.FileManager;

public class ConversorArquivo implements Conversor {

	public ConversorArquivo() {

	}

	@Override
	public List<String> lerArquivo(List<Path> arquivosCarregados) throws IOException {
		List<String> lines = new ArrayList<String>();
		for (Path path : arquivosCarregados) {
			lines.addAll(retornaDados(path));
		}
		return lines;
	}
	
	

	private List<String> retornaDados(Path path) throws IOException {
		FileManager fileManager = new DatFileManager(path);
		return fileManager.read();
	}

}
