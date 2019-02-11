package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.builder.BuilderVendedor;
import com.lucassilva.ilegrachallenge.config.ArquivoPosicoesConfig;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.model.Vendedor;

public class ConversorVendedor extends ConversorDado {

	@Override
	public DadoFaturamento convert(String data) {
		
		String[] campos = data.split(SEPARADOR_DADOS);

		Vendedor vendedor = BuilderVendedor.builder()
										   .cpf(campos[ArquivoPosicoesConfig.POSICAO_VENDEDOR_CPF])
										   .nome(campos[ArquivoPosicoesConfig.POSICAO_VENDEDOR_NOME])
										   .salario(new Double(campos[ArquivoPosicoesConfig.POSICAO_VENDEDOR_SALARIO]))
										   .get();

		return vendedor;
	}

}
