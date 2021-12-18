package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.controller.MatchingController;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Pair;
import pairmatching.view.OutputView;

public class PairFactory {

	private static final int COURSE_INDEX = 0;
	private static final int MISSION_INDEX = 2;
	private static int PAIR_SIZE = 2;

	private PairFactory() {
	}

	public static List<Pair> makePairs() {
		List<String> information = MatchingController.controlInformationSelect();
		String course = information.get(COURSE_INDEX);
		List<Pair> pairs = new ArrayList<>();
		if (course.equals(Course.BACKEND.getName())) {
			pairs = pairMatching(CrewFactory.loadBackendCrews(), information);
			OutputView.printPair(pairs);
		}
		if (course.equals(Course.FRONTEND.getName())) {
			pairs = pairMatching(CrewFactory.loadFrontendCrews(), information);
			OutputView.printPair(pairs);
		}
		return pairs;
	}

	private static List<Pair> pairMatching(List<Crew> crews, List<String> information) {
		List<String> shuffledCrew = Randoms.shuffle(
			crews.stream().map(Crew::getName).collect(Collectors.toList()));
		List<String> twoCrews = new ArrayList<>();
		List<Pair> pairs = new ArrayList<>();
		for (String crew : shuffledCrew) {
			twoCrews.add(crew);
			if (isOddAndLastPair(pairs, shuffledCrew)) {
				System.out.println(shuffledCrew.size());
				PAIR_SIZE = 3;
			}
			if (twoCrews.size() == PAIR_SIZE) {
				pairs.add(calculatePair(twoCrews, information));
				twoCrews = new ArrayList<>();
			}
		}
		return pairs;
	}

	private static boolean isOddAndLastPair(List<Pair> pairs, List<String> crews) {
		return crews.size() % 2 == 1 && pairs.size() == crews.size() / 2 - 1;
	}

	private static Pair calculatePair(List<String> crews, List<String> information) {
		String mission = information.get(MISSION_INDEX);
		List<String> pair = new ArrayList<>(crews);
		return new Pair(pair, mission);
	}
}
