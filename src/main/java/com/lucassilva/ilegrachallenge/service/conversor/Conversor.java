package com.lucassilva.ilegrachallenge.service.conversor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.lucassilva.ilegrachallenge.model.DadoFaturamento;

public interface Conversor {

	public List<DadoFaturamento> lerArquivo(File arquivo) throws IOException;
	DadoFaturamento converter(String data);

}
