package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairCrews {
	private Course course;
	private Level level;
	private Mission mission;
	private List<PairCrew> pairCrews = new ArrayList<>();

	public PairCrews(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public void addPair(PairCrew pairCrew) {
		pairCrews.add(pairCrew);
	}

	public List<PairCrew> get() {
		return pairCrews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course.toString(), level.toString(), mission.toString());
	}

	public void addOddCrew(Crew crew) {
		pairCrews.get(pairCrews.size() - 1).add(crew);
	}
}
