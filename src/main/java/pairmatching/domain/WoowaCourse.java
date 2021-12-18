package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

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

	public List<Crew> load() {
		List<Crew> crews = new ArrayList<>();
		try {
			crews.addAll(DomainConfig.readCrews("backend-crew.md"));
		} catch (Exception e) {
		}
		return crews;
	}
}
