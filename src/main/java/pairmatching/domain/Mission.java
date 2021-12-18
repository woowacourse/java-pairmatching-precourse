package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import pairmatching.domain.crew.BackendCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.FrontendCrewRepository;

public class Mission {
	private List<List<Crew>> pairs;
	private Course course;
	private Level level;
	private String name;

	public Mission(Course course, Level level, String name) {
		pairs = new ArrayList<>();
		this.course = course;
		this.level = level;
		this.name = name;
	}

	public void setPairs(List<List<Crew>> pairs) {
		this.pairs = pairs;
	}

	public List<List<Crew>> getPairs() {
		return pairs;
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

	public boolean haveSamePair(List<List<Crew>> targetPairs) {
		if (!isMatched()) {
			return false;
		}
		for (List<Crew> pair : targetPairs) {
			if (checkParisMeet(pair))
				return true;
		}
		return false;
	}

	private boolean checkParisMeet(List<Crew> pair) {
		for (Crew crew : pair) {
			if (haveMeet(pair, crew)) {
				return true;
			}
		}
		return false;
	}

	private boolean haveMeet(List<Crew> pair, Crew crew) {
		if (course == Course.BACKEND) {
			return BackendCrewRepository.haveMeet(crew, pair);
		}
		if (course == Course.FRONTEND) {
			return FrontendCrewRepository.haveMeet(crew, pair);
		}
		return false;
	}

	public boolean isMatched() {
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
}
