package com.lucassilva.ilegrachallenge.service.conversor;

import com.lucassilva.ilegrachallenge.builder.BuilderCliente;
import com.lucassilva.ilegrachallenge.config.ArquivoPosicoesConfig;
import com.lucassilva.ilegrachallenge.model.Cliente;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;

public class ConversorCliente extends ConversorDado {

	
	@Override
	public DadoFaturamento convert(String data) {
		String[] campos = data.split(CARACTER_SEPARADOR);

		Cliente cliente = BuilderCliente.builder()
										.cnpj(campos[ArquivoPosicoesConfig.POSICAO_CLIENTE_CNPJ])
										.nome(campos[ArquivoPosicoesConfig.POSICAO_CLIENTE_NOME])
										.areaNegocio(campos[ArquivoPosicoesConfig.POSICAO_CLIENTE_AREA_NEGOCIO])
										.get();

		return cliente;
	}

}
