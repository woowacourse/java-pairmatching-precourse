package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class PairCrews {
	private final List<PairCrew> pairCrews;

	public PairCrews(List<PairCrew> pairCrews) {
		this.pairCrews = new ArrayList<>(pairCrews);
	}

	public PairCrews() {
		this.pairCrews = new ArrayList<>();
	}

	public static PairCrews from() {
		return new PairCrews();
	}

	public static PairCrews of(List<PairCrew> pairCrews) {
		return new PairCrews(pairCrews);
	}

	public void add(List<Crew> crews) {
		PairCrew pairCrew = PairCrew.of(crews);
		pairCrews.add(pairCrew);
	}
}
