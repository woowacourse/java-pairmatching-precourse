package pairmatching.model;

import java.util.List;

public class Pair {
	private List<Crew> crews;

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
}
