package pairmatching.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class DomainConfig {
	private static final String PATH = "./src/main/resources/";

	public static Stream<String> readCrews(String name) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(PATH + name));
		return reader.lines();
	}
}
