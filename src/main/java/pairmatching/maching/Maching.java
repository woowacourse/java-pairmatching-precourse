package pairmatching.maching;

import java.util.List;

import pairmatching.edu.Course;
import pairmatching.edu.Level;

public class Maching {
	private Course course;
	private Level level;
	private List<Pair> pairList;

	public Maching(Course course, Level level, List<Pair> pairList) {
		this.course = course;
		this.level = level;
		this.pairList = pairList;
	}

	public Level getLevel() {
		return level;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	public Course getCourse() {
		return course;
	}
}
