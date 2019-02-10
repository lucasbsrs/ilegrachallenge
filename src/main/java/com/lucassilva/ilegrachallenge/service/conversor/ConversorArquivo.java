package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.lucassilva.ilegrachallenge.enums.TipoDadoEnum;
import com.lucassilva.ilegrachallenge.model.Data;
import com.lucassilva.ilegrachallenge.service.file.DatFileManager;
import com.lucassilva.ilegrachallenge.service.file.FileManager;

public class ConversorArquivo implements Conversor {

	private static final int BEGIN_PREFIX = 0;
	private static final int END_PREFIX = 3;

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

	@Override
	public Data convert(String data) {
		String prefix = data.substring(BEGIN_PREFIX, END_PREFIX);
		TipoDadoEnum typeDataEnum = TipoDadoEnum.getFromPrefix(prefix);
		return typeDataEnum.getConversorDado().convert(data);
	}

}
