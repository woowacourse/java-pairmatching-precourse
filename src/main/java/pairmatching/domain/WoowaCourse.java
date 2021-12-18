package pairmatching.domain;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import pairmatching.config.DomainConfig;

public class WoowaCourse {

	public static final String ERROR_LEVEL_MISSION = "레벨에 맞는 미션이 아닙니다.";
	private final Course course;
	private final Level level;
	private final Mission mission;

	public WoowaCourse(Course course, Level level, Mission mission) {
		validateLevelMission(level, mission);
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	private void validateLevelMission(Level level, Mission mission) {
		if (!level.contains(mission)) {
			throw new IllegalArgumentException(ERROR_LEVEL_MISSION);
		}
	}

	public List<String> loadCrewInfo() {
		try {
			return DomainConfig.readCrews(course.getFileName()).collect(Collectors.toList());
		} catch (IOException e) {
			throw new IllegalArgumentException("파일을 읽는도중 에러가 발생했습니다.");
		}
	}

	public boolean isSameLevel(WoowaCourse woowaCourse) {
		return this.level == woowaCourse.level;
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
		return course == that.course && level == that.level && mission == that.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
