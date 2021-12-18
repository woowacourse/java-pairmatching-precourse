package pairmatching.domain.matcing;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

public class Matching {

	private Course course;
	private Level level;
	private Mission mission;
	private List<Pair> pairs;

	public Matching(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pairs = new ArrayList<>();
	}

}
