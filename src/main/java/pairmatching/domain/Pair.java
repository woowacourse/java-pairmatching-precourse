package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
	public final List<Crew> pairCrews = new ArrayList<>();

	public Pair(Crew first, Crew second) {
		pairCrews.add(first);
		pairCrews.add(second);
	}

	public void add(Crew crew) {
		pairCrews.add(crew);
	}
}
