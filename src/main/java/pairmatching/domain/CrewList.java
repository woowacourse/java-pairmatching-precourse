package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewList {
	private final List<Crew> crewList = new ArrayList<>();
	private final List<String> crewNames = new ArrayList<>();

	public CrewList(Course course, String crewNames) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(crewNames));
		List<Crew> crewList = new ArrayList<>();
		String crewName;
		while ((crewName = reader.readLine()) != null) {
			Crew crew = new Crew(course, crewName);
			this.crewList.add(crew);
			this.crewNames.add(crewName);
		}
		reader.close();
	}

	public List<String> getShuffledCrew() {
		return Randoms.shuffle(crewNames);
	}
}
