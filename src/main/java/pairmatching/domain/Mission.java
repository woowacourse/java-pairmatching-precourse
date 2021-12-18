package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import pairmatching.domain.crew.Crew;

public class Mission {
	private List<Set<Crew>> pairs;
	private Course course;
	private Level level;
	private String name;

	public Mission(Course course, Level level, String name) {
		pairs = new ArrayList<>();
		this.course = course;
		this.level = level;
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public boolean isMatchMission(List<String> missionInput) {
		return course.toString().equals(missionInput.get(0))
			&& level.toString().equals(missionInput.get(1))
			&& name.equals(missionInput.get(2));
	}

	public boolean isSameCourse(Course course) {
		return this.course == course;
	}

	public boolean isSameLevel(Level level) {
		return this.level == level;
	}

	public boolean haveSamePair(List<Set<Crew>> targetPairs) {
		if (!isMatched()) {
			return false;
		}
		for(Set<Crew> thisCrew: pairs) {
			if (haveSameCrew(targetPairs, thisCrew))
				return true;
		}
		return false;
	}

	private boolean haveSameCrew(List<Set<Crew>> targetPairs, Set<Crew> thisCrew) {
		for(Set<Crew> targetCrew: targetPairs) {
			Set<Crew> combineCrew = new HashSet<>();
			combineCrew.addAll(targetCrew);
			combineCrew.addAll(targetCrew);
			if (thisCrew.size() + targetCrew.size() - 2 >= combineCrew.size())
				return true;
		}
		return false;
	}

	private boolean isMatched() {
		return pairs.size() != 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Mission mission = (Mission)o;
		return course == mission.course && level == mission.level && Objects.equals(name, mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, name);
	}

	public void setPairs(List<Set<Crew>> pairs) {
		this.pairs = pairs;
	}
}
