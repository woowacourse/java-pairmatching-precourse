package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairResults {
	private List<PairResult> pairResults;

	public PairResults() {
		pairResults = new ArrayList<>();
	}

	public void addPairResults(PairResult pairResult) {
		pairResults.add(pairResult);
	}
}
