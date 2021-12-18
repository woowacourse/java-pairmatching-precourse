package pairmatching.domain;

import java.util.List;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

public class Mission {
	private Course course;
	private Level level;
	private String name;
	private List<Pair> pairList;

	public Mission(Course course, Level level, String name, List<Pair> pairList) {
		this.course = course;
		this.level = level;
		this.name = name;
		this.pairList = pairList;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public List<Pair> getPairList() {
		return pairList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		pairList.forEach(pair -> sb.append(pair).append("\n"));
		return sb.toString();
	}
}
