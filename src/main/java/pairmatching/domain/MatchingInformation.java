package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchingInformation {
	private Course course;
	private Level level;
	private Mission mission;

	private MatchingInformation(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public static MatchingInformation of(String line) {
		List<String> information = split(line);
		Course course = Course.findByName(information.get(0));
		Level level = Level.findByName(information.get(1));
		Mission mission = Mission.findByName(information.get(2));
		return new MatchingInformation(course, level, mission);
	}

	private static List<String> split(String line) {
		List<String> information = Arrays.asList(line.split(","));
		return information.stream().map(string -> string.trim()).collect(Collectors.toList());
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}
}
