package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.dto.ChoiceDto;

public class Match {

	private Course course;
	private String level;
	private String mission;

	public Match(Course course, String level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public static Match of(ChoiceDto choiceDto) {
		Course course = Course.of(choiceDto.getCourse());
		return new Match(course, choiceDto.getLevel(), choiceDto.getMission());
	}

	public Course getCourse() {
		return course;
	}

	public String getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}
}
