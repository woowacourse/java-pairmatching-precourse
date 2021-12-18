package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Pair;
import pairmatching.utils.Constant;

public class OutputView {
	public static void printFunctionType() {
		System.out.println(Constant.SELECT_FUNCTION);
		System.out.println(Constant.PAIR_MATCHING);
		System.out.println(Constant.PAIR_SEARCHING);
		System.out.println(Constant.PAIR_INITIALIZING);
		System.out.println(Constant.QUIT);
	}

	public static void printCourseAndLevelAndMission() {
		System.out.println(Constant.BOUNDARY);
		System.out.println(Constant.COURSE);
		System.out.println(Constant.MISSION);
		System.out.println(Constant.LEVEL1);
		System.out.println(Constant.LEVEL2);
		System.out.println(Constant.LEVEL3);
		System.out.println(Constant.LEVEL4);
		System.out.println(Constant.LEVEL5);
		System.out.println(Constant.BOUNDARY);
		System.out.println(Constant.SELECT_COURSE_LEVEL_MISSION);
		System.out.println(Constant.EXAMPELE);
	}

	public static void printPairs(List<Pair> pairs) {
		if (pairs.isEmpty()) {
			System.out.println(Constant.ERROR + Constant.NO_PAIR_MESSAGE);
		}
		for (Pair pair : pairs) {
			System.out.println(pair.getCrews()
				.stream()
				.map(crew -> crew.getName())
				.collect(Collectors.joining(" : ")));
		}
	}
}
