package pairmatching.service;

import static pairmatching.exception.LevelMissionException.*;

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

	public Match createMatch(String course, String level, String mission) throws IOException {
		checkMatchLevelAndMission(level, mission);
		return matchRepository.save(Course.findCourseByName(course),
			Level.findLevelByName(level),
			Mission.findMissionByName(mission));
	}

	public boolean findMatch(String course, String level, String mission) {
		return matchRepository.findBySource(course, level, mission) != null;
	}

	public Match look(String course, String level, String mission) {
		return matchRepository.findBySource(course, level, mission);

	}

	public void init() {
		matchRepository = new MatchRepository();
	}
}
