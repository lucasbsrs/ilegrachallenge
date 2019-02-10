package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.builder.BuilderVendedor;
import com.lucassilva.ilegrachallenge.model.Data;
import com.lucassilva.ilegrachallenge.model.Vendedor;

public class ConversorVendedor extends ConversorDado {

	@Override
	public Data convert(String data) {
		String[] campos = data.split(SEPARATOR_CHARACTER);

		Vendedor vendedor = BuilderVendedor.builder()
										   .cpf(campos[1])
										   .nome(campos[2])
										   .salario(new Double(campos[3]))
										   .get();

		return vendedor;
	}

}
