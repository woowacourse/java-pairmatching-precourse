package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairMatching {
	Course course;
	Level level;
	Mission mission;
	List<Crew> pairMatchingCrews = new ArrayList<>();

	public PairMatching(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course.toString(), level.toString(), mission.toString());
	}
}
