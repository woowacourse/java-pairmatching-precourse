package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Crews {
	private List<Crew> backEndList = new ArrayList<>();
	private List<Crew> frontEndList = new ArrayList<>();

	public void addBackEndCrews(List<String> crewNames) {
		for (String crewName : crewNames) {
			backEndList.add(new Crew(Course.BACKEND, crewName));
		}
	}

	public void addFrontEndCrews(List<String> crewNames) {
		for (String crewName : crewNames) {
			frontEndList.add(new Crew(Course.FRONTEND, crewName));
		}
	}

}
