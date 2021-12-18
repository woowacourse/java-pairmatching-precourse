package pairmatching.service;

import java.io.IOException;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Match;
import pairmatching.model.Mission;
import pairmatching.repository.MatchRepository;

public class PairService {

	MatchRepository matchRepository;

	public PairService() {
		matchRepository = new MatchRepository();
	}

	public Match match(String course, String level, String mission) throws IOException {
		return matchRepository.save(Course.findCourseByName(course),
			Level.findLevelByName(level),
			Mission.findMissionByName(mission));
	}

	public boolean findMatch(String course, String level, String mission) {
		if (matchRepository.findBySource(course, level, mission) != null) {
			return true;
		}
		return false;
	}

	public void look(String source) {
	}

	public void init() {
	}
}
