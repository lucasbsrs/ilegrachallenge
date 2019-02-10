package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.model.DadoFaturamento;

public abstract class ConversorDado {

	protected static final String CARACTER_SEPARADOR = "ç";

	public abstract DadoFaturamento convert(String data);

}
