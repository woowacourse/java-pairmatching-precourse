package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class Pairs {
	private Level level;
	private Course course;
	private String mission;
	private List<Pair> pairs = new ArrayList<>();

	public Pairs(Level level, Course course, String mission) {
		this.level = level;
		this.course = course;
		this.mission = mission;
	}

	public void addPair(String name1, String name2) {
		Pair pair = new Pair(name1, name2);
		pairs.add(pair);
	}

	public void addPair(String name1, String name2, String name3) {
		Pair pair = new Pair(name1, name2, name3);
		pairs.add(pair);
	}

	public boolean find(Level level, Course course, String mission) {
		if (!this.level.equals(level)) {
			return false;
		}
		if (!this.course.equals(course)) {
			return false;
		}
		if (!this.mission.equals(mission)) {
			return false;
		}
		return true;
	}
}
