package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import com.lucassilva.ilegrachallenge.model.Data;

public interface Conversor {

	public List<String> lerArquivo(List<Path> arquivosCarregados) throws IOException;
	Data convert(String data);

}
