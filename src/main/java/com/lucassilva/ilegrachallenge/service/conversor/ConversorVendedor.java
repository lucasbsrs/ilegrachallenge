package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.builder.BuilderVendedor;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.model.Vendedor;

public class ConversorVendedor extends ConversorDado {

	@Override
	public DadoFaturamento convert(String data) {
		String[] campos = data.split(CARACTER_SEPARADOR);

		Vendedor vendedor = BuilderVendedor.builder()
										   .cpf(campos[1])
										   .nome(campos[2])
										   .salario(new Double(campos[3]))
										   .get();

		return vendedor;
	}

}
