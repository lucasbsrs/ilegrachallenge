package com.lucassilva.ilegrachallenge.enums;

import java.util.Arrays;
import java.util.List;

import com.lucassilva.ilegrachallenge.service.conversor.ConversorDado;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorVendedor;

public enum TipoDadoEnum {

	VENDEDOR("001", new ConversorVendedor()), 
	CLIENTE("002", null), 
	VENDA("003", null);

	private String codigo;
	private ConversorDado conversorDado;

	private TipoDadoEnum(String codigo, ConversorDado conversorDado) {
		this.codigo = codigo;
		this.conversorDado = conversorDado;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public ConversorDado getConversorDado() {
		return conversorDado;
	}
	
	public static TipoDadoEnum getFromPrefix(String codigo) {
		List<TipoDadoEnum> listaTipoDados = Arrays.asList(values());
		return listaTipoDados.stream().filter(x -> x.codigo.equals(codigo)).findFirst().orElse(null);
	}

}
