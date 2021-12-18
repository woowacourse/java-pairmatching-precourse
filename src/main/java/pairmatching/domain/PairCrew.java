package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;

public class PairCrew {
	private static final String PRINT_FORMAT = " : ";

	List<Crew> pairCrews;

	public PairCrew(List<Crew> pairCrews) {
		this.pairCrews = pairCrews;
	}

	public void add(Crew crew) {
		pairCrews.add(crew);
	}

	@Override
	public String toString() {
		return pairCrews.stream()
			.map(crew -> crew.toString())
			.collect(Collectors.joining(PRINT_FORMAT));
	}
}
