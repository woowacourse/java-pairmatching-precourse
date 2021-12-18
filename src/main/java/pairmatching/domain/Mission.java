package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.utils.Constant;
import pairmatching.utils.PairGenerator;

public class Mission {
	private final String name;
	private final Course course;
	private final Level level;
	private List<Pair> pairs = new ArrayList<>();

	public Mission(String name, Course course, Level level) {
		this.name = name;
		this.course = course;
		this.level = level;
	}

	public void makePairs() {
		try {
			this.pairs = PairGenerator.generatePairs(this);
		} catch (IllegalArgumentException e) {
			System.out.println(Constant.ERROR + e.getMessage());
		}
	}

	public boolean isNotMatching() {
		return pairs.size() == 0;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public boolean isSameLevel(Level level) {
		return this.level.equals(level);
	}

	public boolean isSameCourse(Course course) {
		return this.course.equals(course);
	}

	public boolean isFrontEnd() {
		return this.course == Course.FRONTEND;
	}

	public String getName() {
		return name;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
}
