package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchGroup;
import pairmatching.exception.MatchDataNotFoundException;

public class MatchGroupRepository {

	private final List<MatchGroup> matchGroups = new ArrayList<>();

	public MatchGroupRepository() {
		reset();
	}

	public void reset() {
		matchGroups.clear();
		for (Course course : Course.values()) {
			for (Level level : Level.values()) {
				level.getMissions().forEach(mission -> {
					MatchGroup matchGroup = new MatchGroup(course, level, mission);
					matchGroups.add(matchGroup);
				});
			}
		}
	}

	public MatchGroup findOne(Course course, Level level, String mission) {
		return matchGroups.stream()
			.filter(matchGroup -> matchGroup.isEquals(course, level, mission))
			.findAny()
			.orElseThrow(MatchDataNotFoundException::new);
	}

}
