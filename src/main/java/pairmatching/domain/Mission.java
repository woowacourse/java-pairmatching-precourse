package pairmatching.domain;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Mission {
	private Course course;
	private Level level;
	private String name;

	private Set<Map> pairCrews;

	public Mission(Course course, Level level, String name){
		pairCrews = null;
		this.course = course;
		this.level = level;
		this.name = name;
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

	public Set<Map> getPairCrews() {
		return pairCrews;
	}
}
