package pairmatching.domain;

import java.util.List;
import java.util.Objects;

import pairmatching.Input;

public class SelectedMission {
	private final Course course;
	private final Level level;
	private final Mission mission;

	public SelectedMission(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	private boolean isBackend() {
		return course == Course.BACKEND;
	}

	public List<String> getCrews() {
		if (this.isBackend()) {
			return Input.readBackendCrewName();
		}
		return Input.readFrontendCrewName();
	}

	public boolean isSameLevel(SelectedMission mission) {
		return mission.level == level;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		SelectedMission that = (SelectedMission)o;
		return course == that.course && level == that.level && mission == that.mission;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);
	}
}
