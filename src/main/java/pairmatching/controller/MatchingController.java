package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Mission;
import pairmatching.domain.crew.BackendCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.FrontendCrewRepository;

public class MatchingController {
	public static void run(Mission mission) {
		matchingPairs(mission);

	}

	private static void matchingPairs(Mission mission) {
		List<Crew> crews;
		if (mission.getCourse() == Course.BACKEND) {
			crews = BackendCrewRepository.getRandomOrder();
		}
		if (mission.getCourse() == Course.FRONTEND) {
			crews = FrontendCrewRepository.getRandomOrder();
		}
	}
}
