package pairmatching.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.namespace.QName;

public class Crew {
	private Course course;
	private String name;
	private static List<Crew> backendCrew;
	private static List<Crew> frontendCrew;

	public Crew(Course course, String name) throws IOException {
		this.course = course;
		this.name = name;
		this.backendCrew = getCrew("backend-crew.md", Course.BACKEND)
		this.backendCrew = getCrew("backend-crew.md", Course.FRONTEND)
	}

	private List<Crew> getCrew(String fileName, Course course) throws IOException {
		return Files.lines(Paths.get(fileName))
				.map(name -> {
					try {
						return new Crew(course, name);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				})
				.collect(Collectors.toList());
	}

	public static List<Crew> getBackendCrew() {
		return backendCrew;
	}
	public static List<Crew> getFrontendCrew() {
		return frontendCrew;
	}
}
