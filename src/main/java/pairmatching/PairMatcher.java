package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
	private static final String MESSAGE_NO_MATCH = "[ERROR] 매칭 이력이 없습니다.";
	private static List<Crews> matchResults = new ArrayList<>();

	public void pairMatching() {
		InputView.printCourseAndMission();
		String input = InputView.getInputToMatch();
		matching(input);
	}

	private void matching(String input) {
		List<String> matchingStatus = Parser.matchingStatus(input);
		Crews crews = new Crews(matchingStatus);
		List<Pair> pairList = crews.makePairs();
		ResultView.printMatchingResult(pairList);
		matchResults.add(crews);
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
