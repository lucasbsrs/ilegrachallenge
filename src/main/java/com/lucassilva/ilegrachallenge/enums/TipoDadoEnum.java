package com.lucassilva.ilegrachallenge.enums;

public enum TipoDadoEnum {

	VENDEDOR("001"), CLIENTE("002"), VENDA("003");

	private String codigo;

	private TipoDadoEnum(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

}
