package com.lucassilva.ilegrachallenge;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.model.Cliente;
import com.lucassilva.ilegrachallenge.service.conversor.Conversor;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;

public class ConversorClienteTest {

	@Test
	public void deveConverterCliente() {
		Conversor conversor = new ConversorArquivo();
		Cliente cliente = (Cliente) conversor.converter("002|2345675434544345|Jose da Silva|Rural");
		Assert.assertEquals("2345675434544345", cliente.getCnpj());
		Assert.assertEquals("Jose da Silva", cliente.getNome());
		Assert.assertEquals("Rural", cliente.getAreaNegocio());
	}

}
