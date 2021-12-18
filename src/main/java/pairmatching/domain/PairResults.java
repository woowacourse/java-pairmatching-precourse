package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairResults {
	private static List<PairResult> pairResults = new ArrayList<>();

	public static void addPairResult(PairResult pairResult) {
		pairResults.add(pairResult);
	}

	public static boolean isExist(List<String> matchingOption, PairResult pairResult) {
		return false;
	}

	public static boolean isExistPairResult(Course course, Level level, String mission) {
		for (PairResult pairResult : pairResults) {
			if (pairResult.getCourse().equals(course)
				&& pairResult.getLevel().equals(level) && pairResult.getMission().equals(mission)) {
				return true;
			}
		}
		return false;
	}

	public static PairResult findPairResult(Course course, Level level, String mission) {
		for (PairResult pairResult : pairResults) {
			if (pairResult.getCourse().equals(course)
				&& pairResult.getLevel().equals(level) && pairResult.getMission().equals(mission)) {
				return pairResult;
			}
		}
		return new PairResult(course, level, mission, new ArrayList<>());
	}

	public static void clearPairResults() {
		pairResults.clear();
	}
}
