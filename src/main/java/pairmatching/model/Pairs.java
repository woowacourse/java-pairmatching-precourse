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
			return getPairsWhenCrewSizeOdd(crews);
		}
		return getPairsWhenCrewSizeEven(crews);
	}

	private List<Pair> getPairsWhenCrewSizeOdd(Crews crews) {
		List<Pair> pairs = new ArrayList<>();

		for (int i = 1; i < crews.size() - 3; i += 2) {
			Pair pair = Pair.create(
				crews.getCrew(i - 1),
				crews.getCrew(i)
			);

			pairs.add(pair);
		}
		addLastThreeCrewsToPair(pairs, crews);

		return pairs;
	}

	private void addLastThreeCrewsToPair(List<Pair> pairs, Crews crews) {
		int size = crews.size();

		Pair pair = Pair.create(
			crews.getCrew(size - 3),
			crews.getCrew(size - 2),
			crews.getCrew(size - 1)
		);

		pairs.add(pair);
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
