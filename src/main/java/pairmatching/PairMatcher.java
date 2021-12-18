package pairmatching;

import java.util.List;

public class PairMatcher {
	public void pairMatching() {
		InputView.printCourseAndMission();
		String input = InputView.getInputToMatch();
		matching(input);
	}

	private void matching(String input) {
		List<String> matchingStatus = Parser.matchingStatus(input);
		Crews crews = new Crews(matchingStatus);
		List<Pair> pairList = crews.makePairs();
		ResultView.printMatchingResult();
		for (Pair pair : pairList) {
			System.out.println(pair.toString());
		}
	}

	public void pairQuery() {

	}

	public void pairInitiate() {

	}

	public void end() {

	}
}
