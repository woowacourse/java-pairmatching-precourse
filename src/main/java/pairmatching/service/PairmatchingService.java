package pairmatching.service;

import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Match;
import pairmatching.domain.PairMatch;
import pairmatching.dto.ChoiceDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchRepository;

public class PairmatchingService {

	public PairMatch makePairs(ChoiceDto choiceDto) {
		Match match = Match.of(choiceDto);
		List<Crew> crews = CrewRepository.getShuffledCrews(match);
		PairMatch lastPairMatch = PairMatchRepository.addPairMatches(match, crews);
		return lastPairMatch;
	}

	public PairMatch retrievePairs(ChoiceDto choiceDto) {
		Match match = Match.of(choiceDto);
		PairMatch pairMatches = PairMatchRepository.getPairMatches(match);
		return pairMatches;
	}
}
