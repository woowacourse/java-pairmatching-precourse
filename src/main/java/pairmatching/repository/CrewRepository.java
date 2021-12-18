package pairmatching.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {

	private static final List<Crew> backendCrewList = new ArrayList<>();
	private static final List<Crew> frontEndCrewList = new ArrayList<>();

	public CrewRepository() throws IOException{
		if (backendCrewList.isEmpty() || frontEndCrewList.isEmpty()) {
			setBackendCrewList();
			setFrontendCrewList();
		}
	}

	private void setBackendCrewList() throws IOException{
		BufferedReader reader = new BufferedReader(
			new FileReader("C:\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md")
		);

		String name;
		while ((name = reader.readLine()) != null) {
			backendCrewList.add(new Crew(Course.BACKEND, name));
		}
		reader.close();
	}

	private void setFrontendCrewList() throws IOException{
		BufferedReader reader = new BufferedReader(
			new FileReader("C:\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md")
		);

		String name;
		while ((name = reader.readLine()) != null) {
			frontEndCrewList.add(new Crew(Course.FRONTEND, name));
		}
		reader.close();
	}

	public List<Crew> getByCourse(Course course) {
		if (course == Course.BACKEND) {
			return backendCrewList;
		}

		return frontEndCrewList;
	}
}
