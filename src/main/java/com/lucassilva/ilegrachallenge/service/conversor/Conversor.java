package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface Conversor {

	public List<String> lerArquivo(List<Path> arquivosCarregados) throws IOException;

}
