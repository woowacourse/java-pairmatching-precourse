package pairmatching.service;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Pairs;
import pairmatching.domain.repository.Repository;

public class Matching {

	public static void matching() {
		run();
	}

	private static void run() {
		matchFront();
		matchBack();
	}

	private static void matchFront() {
		for (Level level : Repository.levels) {
			Pairs pairs = new Pairs(Repository.frontendList);
			for (Mission mission : level.missions) {
				confirmRight(pairs, mission);
				mission.frontendPairs = pairs;
			}
		}
	}

	private static void matchBack() {
		for (Level level : Repository.levels) {
			Pairs pairs = new Pairs(Repository.backendList);
			for (Mission mission : level.missions) {
				confirmRight(pairs, mission);
				mission.backendPairs = pairs;
			}
		}
	}

	private static void confirmRight(Pairs pairs, Mission mission) {
	}
}
