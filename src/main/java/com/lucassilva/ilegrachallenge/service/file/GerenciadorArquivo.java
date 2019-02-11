package com.lucassilva.ilegrachallenge.service.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class GerenciadorArquivo {
	public abstract void write(List<String> lines) throws IOException;
	public abstract List<String> read() throws IOException;
	public abstract List<Path> retornaTodosArquivosDiretorio() throws IOException;
}
