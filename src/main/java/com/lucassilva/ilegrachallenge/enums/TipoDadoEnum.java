package com.lucassilva.ilegrachallenge.enums;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import com.lucassilva.ilegrachallenge.service.conversor.ConversorCliente;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorDado;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorVenda;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorVendedor;

public enum TipoDadoEnum {

	VENDEDOR("001", new ConversorVendedor()), 
	CLIENTE("002", new ConversorCliente()), 
	VENDA("003", new ConversorVenda());

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
	
	public static TipoDadoEnum get(String codigo) {
		List<TipoDadoEnum> listaTipoDados = Arrays.asList(values());
		return listaTipoDados.stream().filter(dado -> dado.codigo.equals(codigo)).findFirst().orElseThrow(() -> new NoSuchElementException("Código invalido."));
	}

}
