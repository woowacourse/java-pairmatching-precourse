package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.repository.Repository;
import pairmatching.service.Matching;

public class Application {
	public static void main(String[] args) {
		new PairMatchingController();
	}

	private static void test() {
		// System.out.println(mainInput());
		// System.out.println(wantedMissionInput());
		// System.out.println(rematchingInput());
		// Pairs b = new Pairs(Repository.backendList);
		// System.out.println(b.pairs);
		// Pairs f = new Pairs(Repository.frontendList);
		// System.out.println(f.pairs);

		Matching.matching();

		for (Level level : Repository.levels) {
			for (Mission mission : level.missions) {
				System.out.println(mission.frontendPairs);
			}
		}

		for (Level level : Repository.levels) {
			for (Mission mission : level.missions) {
				System.out.println(mission.backendPairs);
			}
		}

		// System.out.println(Repository.levels);

	}
}
