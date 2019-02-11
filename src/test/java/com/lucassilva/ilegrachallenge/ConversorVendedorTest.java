package com.lucassilva.ilegrachallenge;

import org.junit.Assert;
import org.junit.Test;

import com.lucassilva.ilegrachallenge.model.Vendedor;
import com.lucassilva.ilegrachallenge.service.conversor.Conversor;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;

public class ConversorVendedorTest {

	@Test
	public void deveConverterVendedor() {
		Conversor conversor = new ConversorArquivo();
		Vendedor vendedor = (Vendedor) conversor.converter("001ç1234567891234çDiegoç50000");
		Assert.assertEquals("1234567891234", vendedor.getCpf());
		Assert.assertEquals("Diego", vendedor.getNome());
		Assert.assertEquals(new Double("50000"), vendedor.getSalario());
	}
	
}
