package pairmatching.service;

import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.dto.MatchDto;

public interface MatchingService {

	void loadCrews();

	Crew findCrew();

	List<String> matchCrews(MatchDto matchDto);

	boolean isAlreadyMatched(MatchDto matchDto);

}
