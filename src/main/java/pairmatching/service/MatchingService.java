package pairmatching.service;

import java.util.List;

import pairmatching.dto.MatchDto;

public interface MatchingService {

	void loadCrews();

	List<String> matchCrews(MatchDto matchDto);

	boolean isAlreadyMatched(MatchDto matchDto);

	boolean isNotAlreadyMatched(MatchDto matchDto);

	List<String> getPairResultOfMatchGroup(MatchDto matchDto);

	void resetMatchGroups();

}
