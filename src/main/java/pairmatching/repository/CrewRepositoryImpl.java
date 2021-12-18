package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepositoryImpl implements CrewRepository {

	private static final ResourceFileReader resourceFileReader = new ResourceFileReader();

	private final List<Crew> crews = new ArrayList<>();

	@Override
	public List<Crew> findAll(Course course) {
		return crews.stream()
			.filter(crew -> crew.isCourseEquals(course)).collect(Collectors.toList());
	}

	@Override
	public void load() {
		reset();
	}

	@Override
	public void reset() {
		crews.clear();
		loadFile();
	}

	private void loadFile() {
		loadFileAboutBackend();
		loadFileAboutFrontend();
	}

	private void loadFileAboutBackend() {
		List<String> backendCrewNames = resourceFileReader.readLinesFromFile("backend-crew.md");
		Course backendCourse = Course.BACKEND;
		backendCrewNames.forEach((name) -> {
			Crew crew = new Crew(backendCourse, name);
			crews.add(crew);
		});
	}

	private void loadFileAboutFrontend() {
		List<String> frontendCrewNames = resourceFileReader.readLinesFromFile("frontend-crew.md");
		Course frontendCourse = Course.FRONTEND;
		frontendCrewNames.forEach((name) -> {
			Crew crew = new Crew(frontendCourse, name);
			crews.add(crew);
		});
	}

}
