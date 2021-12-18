package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Pair {
	private Set<Crew> pair;

	public Pair(Set<Crew> pair) {
		this.pair = pair;
	}

	@Override
	public String toString() {
		List<String> nameList = new ArrayList<>();
		for (Crew crew : pair) {
			nameList.add(crew.toString());
		}
		return String.join(" : ", nameList) + "\n";
	}

}
