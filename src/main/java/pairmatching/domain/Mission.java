package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.MissionName;

public class Mission {
	private final Course course;
	private final Level level;
	private final String name;
	private List<Pair> pairList;

	public Mission(Course course, Level level, String name) {
		validateName(name);
		this.course = course;
		this.level = level;
		this.name = name;
		this.pairList = new ArrayList<>();
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

	public void validateName(String name) {
		if (!MissionName.ofLevel(getLevel()).contains(name))
			throw new IllegalArgumentException("[ERROR] " + "그런 미션은 없습니다");
	}

	public void setPairList(List<Pair> result) {
		this.pairList = result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		pairList.forEach(pair -> sb.append(pair).append("\n"));
		return sb.toString();
	}
}
