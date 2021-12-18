package pairmatching.domain;

import java.util.List;


public class PairMatching {
	private Course course;
	private Mission mission;
	private List<MatchingCrew> crewList;

	public PairMatching(Course course, Mission mission, List<MatchingCrew> crewList) {
		this.course = course;
		this.mission = mission;
		this.crewList = crewList;
	}

	public boolean isSame(String course, String level, String mission) {
		return this.course.isSame(course) && this.mission.isSame(level, mission);
	}

	public String getPairMatchingResult() {
		StringBuilder stringBuilder = new StringBuilder();
		for (MatchingCrew matchingCrew : crewList) {
			stringBuilder.append(matchingCrew.toString());
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
