package pairmatching.domain;

import java.util.List;

import pairmatching.domain.unit.Course;
import pairmatching.domain.unit.Level;
import pairmatching.domain.unit.Mission;

public class Crew {
	private Course course;
	private Level level;
	private Mission mission;
	private List<String> names;

	public Crew(Course course, Level level, Mission mission, List<String> names) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.names = names;
	}
}
