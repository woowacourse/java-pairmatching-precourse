package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
	private static final String MESSAGE_NO_MATCH = "[ERROR] 매칭 이력이 없습니다.";
	private static final String NO_NEW_MATCHING = "아니오";
	private static final String ERROR_CAN_NOT_MATCH = "[ERROR] 매칭 시도가 실패하였습니다. ";
	private static List<Crews> matchResults = new ArrayList<>();

	public void pairMatching() {
		InputView.printCourseAndMission();
		String input = InputView.getInputToMatch();
		matching(input);
	}

	private boolean matching(String input) {
		int matchingCount = 0;
		while (true) {
			List<String> matchingStatus = Parser.matchingStatus(input);
			Crews crews = new Crews(matchingStatus);
			if (matchResults.contains(new Crews(matchingStatus))) {
				if (InputView.getReMatching().equals(NO_NEW_MATCHING)) {
					continue;
				}
			}
			List<Pair> pairList = crews.makePairs();
			for (Crews match : matchResults) {
				while (match.isReShuffle(crews) && matchingCount < 4) {
					crews.makePairs();
					matchingCount += 1;
				}
				if (matchingCount > 3) {
					throw new IllegalArgumentException(ERROR_CAN_NOT_MATCH);
				}
			}
			ResultView.printMatchingResult(pairList);
			matchResults.add(crews);
			return true;
		}
	}

	public void pairQuery() {
		InputView.printCourseAndMission();
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
