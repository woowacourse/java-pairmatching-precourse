package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepositoryImpl implements CrewRepository {

	private static ResourceFileReader resourceFileReader = new ResourceFileReader();

	private List<Crew> crews = new ArrayList<>();

	@Override
	public void load() {
		loadFile();
	}

	private void loadFile() {
		List<String> backendCrewNames = resourceFileReader.readLinesFromFile("backend-crew.md");
		Course backendCourse = Course.BACKEND;
		backendCrewNames.forEach((name) -> {
			Crew crew = new Crew(backendCourse, name);
			crews.add(crew);
		});

		List<String> frontendCrewNames = resourceFileReader.readLinesFromFile("frontend-crew.md");
		Course frontendCourse = Course.FRONTEND;
		frontendCrewNames.forEach((name) -> {
			Crew crew = new Crew(backendCourse, name);
			crews.add(crew);
		});
	}

	@Override
	public Crew findOne(String name) {
		return null;
	}

	@Override
	public List<Crew> getAll() {
		return null;
	}

}
