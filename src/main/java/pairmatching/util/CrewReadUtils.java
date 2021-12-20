package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import pairmatching.constant.Course;

public class CrewReadUtils {

	ClassLoader classLoader;

	public CrewReadUtils() {
		this.classLoader = getClass().getClassLoader();
	}

	public List<String> readCrews(Course course) {
		if (course == Course.BACKEND)
			return readBackendCrews();
		if (course == Course.FRONTEND)
			return readFrontendCrews();
		return null;
	}

	private List<String> readBackendCrews() {
		return readLines("backend-crew.md");
	}

	private List<String> readFrontendCrews() {
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
			System.err.println(ExceptionMessage.CREW_READ_FAIL_NOT_FOUND);
		} catch (IOException e) {
			System.err.println(ExceptionMessage.CREW_READ_FAIL_INACCESSIBLE);
		}
		return lines;
	}
}
