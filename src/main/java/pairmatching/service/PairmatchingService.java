package pairmatching.service;

import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Match;
import pairmatching.dto.ChoiceDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchRepository;

public class PairmatchingService {

	public void makePairs(ChoiceDto choiceDto) {
		Match match = Match.of(choiceDto);
		List<Crew> crews = CrewRepository.getShuffledCrews(match);
		PairMatchRepository.addPairMatches(match, crews);
	}
}
