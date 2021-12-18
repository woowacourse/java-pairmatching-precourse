package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TechCourse {
	private List<CrewList> crewTable;
	private static final String BACK_END = "C:\\Users\\admin\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	private static final String FRONT_END = "C:\\Users\\admin\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";
	private static final int COURSE_INDEX = 0;
	private static final String SPLITTER = ", ";

	public TechCourse() {
		this.crewTable = new ArrayList<>();
	}

	public List<String> matchPair(String mission) {
		List<String> missionInfo = Arrays.asList(mission.split(SPLITTER));
		for (CrewList crewList : crewTable) {
			if (crewList.mission().equals(mission)) {
				crewList.shuffleCrewNames();
				return crewList.getCrewNames();
			}
		}
		if (missionInfo.get(COURSE_INDEX).equals(Course.BACKEND.getName())) {
			CrewList backEndCrewList = null;
			try {
				backEndCrewList = new CrewList(missionInfo, BACK_END);
			} catch (IOException e) {
				e.printStackTrace();
			}
			crewTable.add(backEndCrewList);
			assert backEndCrewList != null;
			return backEndCrewList.getCrewNames();
		}
		if (missionInfo.get(COURSE_INDEX).equals(Course.FRONTEND.getName())) {
			CrewList frontEndCrewList = null;
			try {
				frontEndCrewList = new CrewList(missionInfo, FRONT_END);
			} catch (IOException e) {
				e.printStackTrace();
			}
			crewTable.add(frontEndCrewList);
			assert frontEndCrewList != null;
			return frontEndCrewList.getCrewNames();
		}
		return null;
	}

	public boolean isShuffled(String missionName) {
		for (CrewList crewList : crewTable) {
			if (crewList.mission().equals(missionName)) {
				return true;
			}
		}
		return false;
	}

	public List<String> getPairList(String missionName) {
		for (CrewList crewList : crewTable) {
			if (crewList.mission().equals(missionName)) {
				return crewList.getCrewNames();
			}
		}
		return null;
	}

	public void resetPair() {
		crewTable = new ArrayList<>();
	}
}
