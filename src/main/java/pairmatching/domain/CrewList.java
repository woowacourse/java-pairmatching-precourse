package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CrewList {
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;
	private static final String SPLITTER = ", ";

	private final Course course;
	private final Level level;
	private final Mission mission;
	private List<String> crewNames;

	public CrewList(List<String> missionInfo, String crewNames) throws IOException {
		this.course = Course.nameOf(missionInfo.get(COURSE_INDEX));
		this.level = Level.nameOf(missionInfo.get(LEVEL_INDEX));
		this.mission = Mission.nameOf(missionInfo.get(MISSION_INDEX));
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
		return course.getName() + SPLITTER + level.getName() + SPLITTER + mission.getName();
	}

	public List<String> getCrewNames() {
		return crewNames;
	}
}
