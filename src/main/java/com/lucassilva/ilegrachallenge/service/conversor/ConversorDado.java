package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.model.DadoFaturamento;

public abstract class ConversorDado {

	protected static final String SEPARADOR_DADOS = "\\|";

	public abstract DadoFaturamento convert(String data);

}
