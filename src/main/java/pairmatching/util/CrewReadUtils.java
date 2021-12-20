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
import pairmatching.constant.ExceptionMessage;

public class CrewReadUtils {
	private static final String BACKEND_CREW_FILE = "backend-crew.md";
	private static final String FRONTEND_CREW_FILE = "frontend-crew.md";

	public static List<String> readCrews(Course course) {
		if (course == Course.BACKEND)
			return readBackendCrews();
		if (course == Course.FRONTEND)
			return readFrontendCrews();
		return null;
	}

	private static List<String> readBackendCrews() {
		return readLines(BACKEND_CREW_FILE);
	}

	private static List<String> readFrontendCrews() {
		return readLines(FRONTEND_CREW_FILE);
	}

	private static BufferedReader getBufferedReader(String fileName) throws FileNotFoundException {
		InputStream inputStream = CrewReadUtils.class.getClassLoader().getResourceAsStream(fileName);
		if (inputStream == null)
			throw new FileNotFoundException();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
		return new BufferedReader(inputStreamReader);
	}

	private static List<String> readLines(String fileName) {
		List<String> lines = new ArrayList<>();
		try {
			BufferedReader bufferedReader = getBufferedReader(fileName);
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
