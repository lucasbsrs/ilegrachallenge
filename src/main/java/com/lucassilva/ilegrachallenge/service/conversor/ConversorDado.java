package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.model.Data;

public abstract class ConversorDado {

	protected static final String SEPARATOR_CHARACTER = "ç";

	public abstract Data convert(String data);

}
