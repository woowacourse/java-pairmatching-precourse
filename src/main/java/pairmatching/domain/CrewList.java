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
	private List<String> crewNames;

	public CrewList(List<String> missionInfo, String crewNames) throws IOException {
		this.course = Course.nameOf(missionInfo.get(0));
		this.level = Level.nameOf(missionInfo.get(1));
		this.mission = Mission.nameOf(missionInfo.get(2));
		BufferedReader reader = new BufferedReader(new FileReader(crewNames));
		List<String> tempCrewNames = new ArrayList<>();
		String crewName;
		while ((crewName = reader.readLine()) != null) {
			tempCrewNames.add(crewName);
		}
		this.crewNames = Randoms.shuffle(tempCrewNames);
		reader.close();
	}

	public void shuffleCrewNames() {
		crewNames = Randoms.shuffle(crewNames);
	}

	public String mission() {
		return course.getName() + ", " + level.getName() + ", " + mission.getName();
	}

	public List<String> getCrewNames() {
		return crewNames;
	}
}
