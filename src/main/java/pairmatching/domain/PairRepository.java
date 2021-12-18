package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PairRepository {
	private static final String NEW_LINE = "\n";
	private static final String PAIR_DELIMITER = " : ";

	private final Map<MatchParams, List<List<String>>> pairs = new HashMap<>();

	public void addPair(MatchParams params, List<List<String>> crews) {
		pairs.put(params, crews);
	}

	public String getMatchResultString(MatchParams params) {
		List<List<String>> pairList = new ArrayList<>();
		for (MatchParams matchParams : pairs.keySet()) {
			if (matchParams.equals(params)) {
				pairList = pairs.get(matchParams);
				break;
			}
		}

		return pairList.stream()
			.map(item -> String.join(PAIR_DELIMITER, item))
			.collect(Collectors.joining(NEW_LINE));
	}

	public boolean isExistParam(MatchParams params) {
		for (MatchParams matchParams : pairs.keySet()) {
			if (matchParams.equals(params))
				return true;
		}

		return false;
	}

	public void resetPairs() {
		pairs.clear();
	}

	public List<String> getPairsByCourseAndLevel(Course course, Level level) {
		List<String> result = new ArrayList<>();
		for (MatchParams params : pairs.keySet()) {
			if(params.getCourse().equals(course) && params.getLevel().equals(level)) {
				List<List<String>> pairNameList = pairs.get(params);
				result.addAll((pairNameList.stream()
					.map(item -> String.join(PAIR_DELIMITER, item))
					.collect(Collectors.toList())));
			}
		}

		return result;
	}
}
