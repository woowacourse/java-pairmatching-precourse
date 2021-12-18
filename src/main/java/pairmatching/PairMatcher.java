package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {
	private List<Crews> matchResults = new ArrayList<>();

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
		this.matchResults.add(crews);
	}

	public void pairQuery() {
		List<String> matchingStatus = Parser.matchingStatus(InputView.getInputToMatch());
		Crews newCrews = new Crews(matchingStatus);
		for (Crews crews : this.matchResults) {
			if (crews.already(newCrews)) {
				System.out.println("있다");
			}
		}
		System.out.println("없다");
	}

	public void pairInitiate() {
		this.matchResults.clear();
		ResultView.printMatchInitiated();
	}
}
