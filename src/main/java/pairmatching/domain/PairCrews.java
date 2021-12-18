package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairCrews {
	Course course;
	Level level;
	Mission mission;
	List<PairCrew> pairMatchingCrews = new ArrayList<>();

	public PairCrews(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public void addPair(PairCrew pairCrew) {
		pairMatchingCrews.add(pairCrew);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course.toString(), level.toString(), mission.toString());
	}
}
