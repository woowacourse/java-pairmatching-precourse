package pairmatching.pair;

import java.util.List;

public class Pair {
	private static final int ZERO = 0;
	private static final int TWICE = 2;

	private List<String> crews;
	private PairTarget pairTarget;

	public Pair(List<String> crews, PairTarget pairTarget) {
		this.crews = crews;
		this.pairTarget = pairTarget;
	}

	public boolean isDuplicate(Pair pair) {
		return this.pairTarget.isSameLevel(pair.pairTarget) && duplicateCrews(pair);
	}

	public boolean duplicateCrews(Pair pair) {
		int SameNameCount = ZERO;
		for (String each : pair.crews) {
			if (this.crews.stream().anyMatch(crews -> crews.equals(each))) {
				SameNameCount++;
			}
		}
		return SameNameCount >= TWICE;
	}

	public boolean isSamePairTarget(PairTarget pairTarget) {
		return this.pairTarget.isSame(pairTarget);
	}

	public List<String> getCrews() {
		return crews;
	}
}
