package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
	private static final String MESSAGE_NO_MATCH = "[ERROR] 매칭 이력이 없습니다.";
	private static final String NO_NEW_MATCHING = "아니오";
	private static List<Crews> matchResults = new ArrayList<>();

	public void pairMatching() {
		InputView.printCourseAndMission();
		String input = InputView.getInputToMatch();
		matching(input);
	}

	private boolean matching(String input) {
		while (true) {
			List<String> matchingStatus = Parser.matchingStatus(input);
			Crews crews = new Crews(matchingStatus);
			if (matchResults.contains(new Crews(matchingStatus))) {
				if (InputView.getReMatching().equals(NO_NEW_MATCHING)) {
					continue;
				}
			}
			List<Pair> pairList = crews.makePairs();
			ResultView.printMatchingResult(pairList);
			matchResults.add(crews);
			return true;
		}
	}

	private boolean hasMatchingStatus(String input) {
		List<String> matchingStatus = Parser.matchingStatus(input);
		if (matchResults.contains(new Crews(matchingStatus))) {
			InputView.getReMatching();
			return true;
		}
		return false;
	}

	public void pairQuery() {
		List<String> matchingStatus = Parser.matchingStatus(InputView.getInputToMatch());
		if (!matchResults.contains(new Crews(matchingStatus))) {
			throw new IllegalArgumentException(MESSAGE_NO_MATCH);
		}
		int index = matchResults.indexOf(new Crews(matchingStatus));
		ResultView.printMatchingResult(matchResults.get(index).getPairs());
	}

	public void pairInitiate() {
		matchResults.clear();
		ResultView.printMatchInitiated();
	}
}
