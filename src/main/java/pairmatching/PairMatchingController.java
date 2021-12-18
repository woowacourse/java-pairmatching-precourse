package pairmatching;

import pairmatching.domain.Crews;
import pairmatching.domain.Pair;
import pairmatching.domain.PairCrews;
import pairmatching.domain.Pairs;
import pairmatching.dto.PairDto;

public class PairMatchingController {
	private final Pairs pairs;
	private final Crews frontEndCrews;
	private final Crews backEndCrews;

	public PairMatchingController(Crews frontEndCrews, Crews backEndCrews) {
		this.frontEndCrews = frontEndCrews;
		this.backEndCrews = backEndCrews;
		this.pairs = new Pairs();
	}

	public PairCrews matchCrews(PairDto pairDto) {
		Pair pair = pairDto.toPair();
		if(pair.isFrontEnd()) {
			pair.matchCrew(frontEndCrews);
		} else if(pair.isBackEnd()) {
			pair.matchCrew(backEndCrews);
		}
		pairs.add(pair);
		return pair.getPairCrews();
	}
}
