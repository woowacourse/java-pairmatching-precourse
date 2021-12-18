package pairmatching.service;

import java.util.List;
import pairmatching.domain.Crew;

public interface MatchingService {

	void loadCrews();

	Crew findCrew();

	List<String> matchCrews();

}
