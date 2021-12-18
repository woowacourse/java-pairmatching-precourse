package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class PairMatchGenerator {
	private static final int ODD_CHECK_VALUE = 1;
	private static final int PAIR_MAXIMUM_VALUE = 2;

	public PairCrews generate(Crews crews) {
		List<Crew> shuffleCrews = Randoms.shuffle(crews.getCrews());
		List<Crew> pairCrew = new ArrayList<>();
		PairCrews pairCrews = PairCrews.from();
		List<Crew> lastPairCrew = getLastPairCrew(shuffleCrews);
		for (Crew shuffleCrew : shuffleCrews) {
			if (pairCrew.size() >= PAIR_MAXIMUM_VALUE) {
				pairCrews.add(pairCrew);
				pairCrew = new ArrayList<>();
			}
			pairCrew.add(shuffleCrew);
		}
		pairCrews.add(lastPairCrew);
		return pairCrews;
	}

	private List<Crew> getLastPairCrew(List<Crew> shuffleCrews) {
		List<Crew> lastPairCrew = new ArrayList<>();
		lastPairCrew.add(shuffleCrews.get(shuffleCrews.size() - 1));
		lastPairCrew.add(shuffleCrews.get(shuffleCrews.size() - 2));
		if (shuffleCrews.size() % 2 == ODD_CHECK_VALUE) {
			lastPairCrew.add(shuffleCrews.get(shuffleCrews.size() - 3));
		}
		return lastPairCrew;
	}
}
