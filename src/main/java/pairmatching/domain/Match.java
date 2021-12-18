package pairmatching.domain;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Match))
			return false;
		Match match = (Match)o;
		return getCourse() == match.getCourse() && Objects.equals(getLevel(), match.getLevel())
			&& Objects.equals(getMission(), match.getMission());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCourse(), getLevel(), getMission());
	}
}
