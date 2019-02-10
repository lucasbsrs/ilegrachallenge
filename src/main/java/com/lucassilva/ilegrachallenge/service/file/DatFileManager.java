package com.lucassilva.ilegrachallenge.service.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatFileManager extends FileManager {

	private static final int PREFIXO_INICIO = 0;
	private static final int PREFIXO_FIM = 3;

	private Stream<Path> stream;

	public DatFileManager(Path path) {
		super();
		super.path = path;
	}

	@Override
	public void write(List<String> lines) throws IOException {
		File file = new File(super.path.toString());
		file.getParentFile().mkdirs();
		try (OutputStream outputStream = new FileOutputStream(file)) {
			if (file.createNewFile()) {
				for (String line : lines) {
					outputStream.write(line.getBytes());
					outputStream.write("\n".getBytes());
				}
			}
		}
	}

	@Override
	public List<String> read() throws IOException {
		List<String> lines = new ArrayList<>();
		try (InputStream is = new FileInputStream(path.toString())) {
			try (Scanner scanner = new Scanner(is)) {
				while (scanner.hasNext()) {
					String linhaAtual = scanner.nextLine().trim();
					String prefixo = linhaAtual.substring(PREFIXO_INICIO, PREFIXO_FIM);
					String[] linhasSplit = linhaAtual.split(prefixo);
					for (String linha : linhasSplit) {
						if (!linha.isEmpty()) {
							lines.add(prefixo + linha);
						}
					}
				}
			}
		}
		return lines;
	}

	@Override
	public List<Path> retornaTodosArquivosDiretorio() throws IOException {
		stream = Files.walk(path);

		return stream.filter(Files::isRegularFile).filter(x -> x.toString().endsWith(".dat"))
				.collect(Collectors.toList());
	}
}
