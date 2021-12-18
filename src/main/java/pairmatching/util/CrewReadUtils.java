package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CrewReadUtils {

	ClassLoader classLoader;

	public CrewReadUtils(){
		this.classLoader = getClass().getClassLoader();
	}

	public List<String> readBackendCrews() {
		return readLines("backend-crew.md");
	}

	public List<String> readFrontendCrews() {
		return readLines("frontend-crew.md");
	}

	private List<String> readLines(String fileName) {
		List<String> lines = new ArrayList<>();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

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
