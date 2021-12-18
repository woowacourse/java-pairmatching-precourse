package pairmatching.repository;

import static pairmatching.exception.LevelMissionException.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Match;
import pairmatching.model.Mission;

public class MatchRepository {

	List<Match> matches;

	public MatchRepository() {
		matches = new ArrayList<>();
	}

	public Match findBySource(String course, String level, String mission) {
		return matches.stream().filter(match -> match.isSame(course, level, mission)).findFirst().orElse(null);
	}

	public Match save(Course course, Level level, Mission mission) throws IOException {
		checkMatchLevelAndMission(level.getName(), mission.getName());
		Match match = new Match(course, level, mission);
		matches.add(match);
		return match;
	}
}
