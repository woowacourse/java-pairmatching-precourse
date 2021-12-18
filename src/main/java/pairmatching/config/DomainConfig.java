package pairmatching.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;

public class DomainConfig {
	private static final String PATH = "./src/main/resources/";

	public static List<Crew> readCrews(String name) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(PATH + name));
		return reader.lines().map(Crew::new).collect(Collectors.toList());
	}
}
