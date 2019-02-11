package com.lucassilva.ilegrachallenge.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.lucassilva.ilegrachallenge.config.ArquivoConfig;
import com.lucassilva.ilegrachallenge.model.AnaliseDados;
import com.lucassilva.ilegrachallenge.model.DadoFaturamento;
import com.lucassilva.ilegrachallenge.service.conversor.AnaliseDadosService;
import com.lucassilva.ilegrachallenge.service.conversor.ConversorArquivo;
import com.lucassilva.ilegrachallenge.util.ArquivoUtil;

@Controller
@EnableScheduling
public class ExportacaoDadosFaturamentoScheduler {

	@Autowired
	private ArquivoUtil arquivoUtil;

	@Autowired
	private ConversorArquivo conversorArquivo;

	@Autowired
	private AnaliseDadosService analiseDadosService;

	@Scheduled(fixedDelay = 3600)
	public void processar() throws IOException {
		criarDiretorios();

		List<File> arquivosValidosNoDiretorio = arquivoUtil.listarArquivosDoDiretorio(ArquivoConfig.PATH_ENTRADA);

		arquivosValidosNoDiretorio.forEach(arquivo -> {
			List<DadoFaturamento> listaArquivo = conversorArquivo.lerArquivo(arquivo);

			AnaliseDados analiseDados = analiseDadosService.analisar(listaArquivo);

			gravarAnalise(arquivo, analiseDados);

			removerArquivo(arquivo);
		});

	}

	private void criarDiretorios() throws IOException {
		arquivoUtil.criarDiretorio(ArquivoConfig.PATH_ENTRADA);
		arquivoUtil.criarDiretorio(ArquivoConfig.PATH_SAIDA);
	}

	private void gravarAnalise(File arquivo, AnaliseDados analiseDados) {
		arquivoUtil.gravarArquivo(
				ArquivoConfig.PATH_SAIDA.resolve(
						arquivo.getName().replace(ArquivoConfig.EXTENSAO_DAT, ArquivoConfig.EXTENSAO_DONE_DAT)),
				analiseDados.getLinhasAnalise().toString());
	}

	private void removerArquivo(File arquivo) {
		arquivoUtil.removerArquivo(arquivo);
	}

}
