package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewList {
	private final Course course;
	private final Level level;
	private final Mission mission;
	private final List<Crew> crewList = new ArrayList<>();
	private final List<String> crewNames = new ArrayList<>();
	private boolean isShuffled = false;

	public CrewList(List<String> missionInfo, String crewNames) throws IOException {
		this.course = Course.nameOf(missionInfo.get(0));
		this.level = Level.nameOf(missionInfo.get(1));
		this.mission = Mission.nameOf(missionInfo.get(2));
		BufferedReader reader = new BufferedReader(new FileReader(crewNames));
		String crewName;
		while ((crewName = reader.readLine()) != null) {
			Crew crew = new Crew(course, crewName);
			this.crewList.add(crew);
			this.crewNames.add(crewName);
		}
		reader.close();
	}

	public List<String> getShuffledCrew() {
		isShuffled = true;
		return Randoms.shuffle(crewNames);
	}

	public String mission() {
		return course.getName() + ", " + level.getName() + ", " + mission.getName();
	}

	public List<String> getCrewNames() {
		return crewNames;
	}
}
