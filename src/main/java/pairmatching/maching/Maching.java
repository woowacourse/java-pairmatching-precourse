package pairmatching.maching;

import java.util.List;

import pairmatching.edu.Course;
import pairmatching.edu.Level;

public class Maching {
	private Course course;
	private Level level;
	private String mission;
	private List<Pair> pairList;

	public Maching(Course course, Level level, String mission, List<Pair> pairList) {
		this.course = course;
		this.level = level;
		this.pairList = pairList;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	public Course getCourse() {
		return course;
	}
}
