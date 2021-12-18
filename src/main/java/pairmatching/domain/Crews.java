package pairmatching.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Crews {

	private List<Crew> crews;

	public Crews(BufferedReader backendCrewData, BufferedReader frontendCrewData) throws IOException {
		crews = generateCrews(backendCrewData, frontendCrewData);
	}

	private List<Crew> generateCrews(BufferedReader backendCrewData, BufferedReader frontendCrewData) throws IOException {
		List<Crew> crewList = new ArrayList<>();
		addCrew(Course.BACKEND, backendCrewData, crewList);
		addCrew(Course.FRONTEND, frontendCrewData, crewList);
		return crewList;
	}

	private void addCrew(Course course, BufferedReader crewData, List<Crew> crewList) throws IOException {
		String crewName;
		while ((crewName = crewData.readLine()) != null) {
			crewList.add(new Crew(course, crewName));
		}
	}

	public List<Crew> getCrews() {
		return crews;
	}

	public List<Crew> findCrews(Course course) {
		return crews.stream()
			.filter(crew -> crew.getCourse() == course)
			.collect(Collectors.toList());
	}
}
