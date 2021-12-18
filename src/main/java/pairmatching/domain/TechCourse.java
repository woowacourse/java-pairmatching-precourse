package pairmatching.domain;

import java.io.IOException;
import java.util.List;

import pairmatching.util.InputValidator;

public class TechCourse {
	private static final String BACK_END = "C:\\Users\\admin\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	private static final String FRONT_END = "C:\\Users\\admin\\IdeaProjects\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

	private final CrewList backEndCrewList;
	private final CrewList frontEndCrewList;

	public TechCourse() {
		try {
			this.backEndCrewList = new CrewList(Course.BACKEND, BACK_END);
			this.frontEndCrewList = new CrewList(Course.FRONTEND, FRONT_END);
		} catch (IOException e) {
			throw new IllegalArgumentException("[ERROR] 파일을 읽어올 수 없습니다.");
		}

	}

	public List<String> matchPair(String mission) {
		List<String> missionInfo = InputValidator.isValidFormat(mission);
		if (missionInfo.get(0).equals("백엔드")) {
			return backEndCrewList.getShuffledCrew();
		}
		if (missionInfo.get(0).equals("프론트엔드")) {
			return frontEndCrewList.getShuffledCrew();
		}
		return null;
	}
}
