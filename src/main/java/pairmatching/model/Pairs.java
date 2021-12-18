package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
	public static final int EVEN = 2;
	public static final int NO_REMAINDER = 0;

	private final List<Pair> pairs;

	public Pairs(Crews crews) {
		pairs = addPairToPairs(crews);
	}

	public static Pairs create(Crews crews) {
		return new Pairs(crews);
	}

	private List<Pair> addPairToPairs(Crews crews) {
		if (isCrewSizeOdd(crews)) {
			//TODO
		}
		return getPairsWhenCrewSizeEven(crews);
	}

	private List<Pair> getPairsWhenCrewSizeEven(Crews crews) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = 1; i < crews.size(); i += 2) {
			Pair pair = Pair.create(
				crews.getCrew(i - 1),
				crews.getCrew(i)
			);

			pairs.add(pair);
		}

		return pairs;
	}

	private boolean isCrewSizeOdd(Crews crews) {
		return crews.size() % EVEN != NO_REMAINDER;
	}
}
