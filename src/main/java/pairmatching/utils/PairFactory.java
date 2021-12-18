package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.sound.sampled.Line.Info;
import pairmatching.controller.MatchingController;
import pairmatching.model.Course;
import pairmatching.model.Crew;
import pairmatching.model.Information;
import pairmatching.model.Pair;
import pairmatching.model.Pairs;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairFactory {

	private static int PAIR_SIZE = 2;

	private PairFactory() {
	}

	public static Pairs checkRePair(Information information) {
		return makePairs(information);
	}

	private static Pairs makePairs(Information information) {
		String course = information.getCourse();
		if (course.equals(Course.BACKEND.getName())) {
			Pairs pairs = pairMatching(CrewFactory.loadBackendCrews(), information);
			OutputView.printPair(pairs);
			return pairs;
		}
		Pairs pairs = pairMatching(CrewFactory.loadFrontendCrews(), information);
		OutputView.printPair(pairs);
		return pairs;
	}

	private static Pairs pairMatching(List<Crew> crews, Information information) {
		information.checkPaired();
		List<String> shuffledCrew = Randoms.shuffle(
			crews.stream().map(Crew::getName).collect(Collectors.toList()));
		List<String> twoCrews = new ArrayList<>();
		List<Pair> pairs = new ArrayList<>();
		for (String crew : shuffledCrew) {
			twoCrews.add(crew);
			if (isOddAndLastPair(pairs, shuffledCrew)) {
				PAIR_SIZE = 3;
			}
			if (twoCrews.size() == PAIR_SIZE) {
				pairs.add(calculatePair(twoCrews));
				twoCrews = new ArrayList<>();
			}
		}
		return new Pairs(pairs, information.getMission(), information.getCourse());
	}

	private static boolean isOddAndLastPair(List<Pair> pairs, List<String> crews) {
		return crews.size() % 2 == 1 && pairs.size() == crews.size() / 2 - 1;
	}

	private static Pair calculatePair(List<String> crews) {
		List<String> pair = new ArrayList<>(crews);
		return new Pair(pair);
	}
}
