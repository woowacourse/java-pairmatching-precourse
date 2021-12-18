package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair {
	private List<Crew> crews;
	private Mission mission;

	private Pair(Mission mission, Crew... crews) {
		this.mission = mission;
		this.crews = new ArrayList<>(Arrays.asList(crews));
	}

	public void addCrew(Crew crew) {
		crews.add(crew);
	}

	public static Pair of(Mission mission, Crew... crews) {
		return new Pair(mission, crews);
	}

	public Mission getMission() {
		return mission;
	}

	public boolean isDuplicatedPair(Pair pair) {
		int count = 0;

		for (Crew crew : crews) {
			count += countOfSameCrew(pair, crew);
		}

		return count >= 2;
	}

	private int countOfSameCrew(Pair pair, Crew crew) {
		int count = 0;
		for (Crew other : pair.getCrews()) {
			if (crew.equals(other)) {
				count++;
			}
		}
		return count;
	}

	public List<Crew> getCrews() {
		return crews;
	}
}
