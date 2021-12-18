package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewReadUtils {

	public static List<String> readBackendCrews() {
		return readLines("backend-crew.md");
	}

	public static List<String> readFrontendCrews() {
		return readLines("frontend-crew.md");
	}

	private static List<String> readLines(String fileName) {
		List<String> lines = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(String.valueOf(ClassLoader.getSystemResource(fileName)));
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null)
				lines.add(line);
			return lines;
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다");
		} catch (IOException e) {
			System.err.println("파일을 읽지 못했습니다");
		}
		return lines;
	}
}
