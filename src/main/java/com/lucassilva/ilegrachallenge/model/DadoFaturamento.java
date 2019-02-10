package com.lucassilva.ilegrachallenge.model;

public abstract class DadoFaturamento {
	public boolean isClass(Class<?> clazz) {
		return this.getClass().equals(clazz);
	}
}
