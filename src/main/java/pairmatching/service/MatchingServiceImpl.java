package pairmatching.service;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchGroup;
import pairmatching.dto.MatchDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.CrewRepositoryImpl;
import pairmatching.repository.MatchGroupRepository;

public class MatchingServiceImpl implements MatchingService {

	private final MatchGroupRepository matchGroupRepository;
	private final CrewRepository crewRepository;
	private final PairMatcher pairMatcher;

	public MatchingServiceImpl() {
		this.matchGroupRepository = new MatchGroupRepository();
		this.crewRepository = new CrewRepositoryImpl();
		this.pairMatcher = new PairMatcher();
	}

	@Override
	public void loadCrews() {
		crewRepository.load();
	}

	@Override
	public List<String> matchCrews(MatchDto matchDto) {
		List<Crew> crews = crewRepository.findAll(matchDto.getCourse());
		List<List<Crew>> crewPairs = pairMatcher.match(crews);

		return null;
	}

	public boolean isAlreadyMatched(MatchDto matchDto) {
		MatchGroup matchGroup = findMatchGroup(matchDto);
		return matchGroup.isAlreadyMatched();
	}

	private MatchGroup findMatchGroup(MatchDto matchDto) {
		Course course = matchDto.getCourse();
		Level level = matchDto.getLevel();
		String missionName = matchDto.getMissionName();
		return matchGroupRepository.findOne(course, level, missionName);
	}

	@Override
	public Crew findCrew() {
		return null;
	}


}
