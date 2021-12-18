package pairmatching.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.config.DomainConfig;

public class WoowaCourse {

	private final Course course;
	private final Level level;
	private final Mission mission;

	public WoowaCourse(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public List<String> load() {
		try {
			return DomainConfig.readCrews(course.getFileName()).collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException("파일을 읽는도중 에러가 발생했습니다.");
		}
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		WoowaCourse that = (WoowaCourse)other;
		return course == that.course && level == that.level && Objects.equals(mission, that.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
