package pairmatching.processor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;

public class FileProcessor {
	private static final String FRONT_END_CREW_FILE_NAME = "frontend-crew.md";
	private static final String BACK_END_CREW_FILE_NAME = "backend-crew.md";

	public List<String> readCrewNames(Course course) throws IOException {
		BufferedReader crewBufferReader = getCrewBufferReader(course);
		List<String> crewNames = crewBufferReader.lines()
			.collect(Collectors.toList());
		crewBufferReader.close();
		return crewNames;
	}

	private BufferedReader getCrewBufferReader(Course course) throws FileNotFoundException {
		URL crewUrl = getCrewUrl(course);
		return new BufferedReader(new FileReader(crewUrl.getPath()));
	}

	private URL getCrewUrl(Course course) throws FileNotFoundException {
		ClassLoader classLoader = getClass().getClassLoader();
		if (course.isFrontEnd()) {
			return classLoader.getResource(FRONT_END_CREW_FILE_NAME);
		} else if (course.isBackEnd()) {
			return classLoader.getResource(BACK_END_CREW_FILE_NAME);
		}
		throw new FileNotFoundException();
	}
}
