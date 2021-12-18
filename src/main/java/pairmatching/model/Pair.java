package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
	private List<Crew> crews = new ArrayList<>();

	//두명일 경우/ 세명일 경우를 유효성 검사해야함

	public void makePair(Crew crew1, Crew crew2) {
		crews.add(crew1);
		crews.add(crew2);
	}

	public void makePair(Crew crew1, Crew crew2, Crew crew3) {
		crews.add(crew1);
		crews.add(crew2);
		crews.add(crew3);
	}

	public int size() {
		return crews.size();
	}

	public String toString() {
		return crews.stream().map(Crew::getName).collect(Collectors.joining(" : "));
	}
}
