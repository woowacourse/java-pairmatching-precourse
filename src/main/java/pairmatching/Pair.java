package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Pair {

	private HashSet<String> pair;

	public Pair(String crew) {
		this.pair = new HashSet<>(Arrays.asList(crew));
	}

	public void addCrew(String crew) {
		this.pair.add(crew);
	}

	@Override
	public String toString() {
		List<String> pairList = new ArrayList<>(pair);
		return String.join(" : ", pairList);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pair pair1 = (Pair)o;
		return Objects.equals(pair, pair1.pair);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pair);
	}
}
