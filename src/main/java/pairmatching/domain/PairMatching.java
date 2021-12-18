package pairmatching.domain;

import java.util.List;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PairMatching that = (PairMatching)o;
		return course == that.course && mission.equals(that.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, mission);
	}
}
