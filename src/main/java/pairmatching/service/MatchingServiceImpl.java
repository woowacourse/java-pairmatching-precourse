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
		this.loadCrews();
	}

	@Override
	public void loadCrews() {
		crewRepository.load();
	}

	@Override
	public List<String> matchCrews(MatchDto matchDto) {
		List<List<Crew>> shuffledCrewPairs = getShuffledCrewPairs(matchDto.getCourse());
		MatchGroup matchGroup = findMatchGroup(matchDto);
		matchGroup.updateCrewPair(shuffledCrewPairs);
		return matchGroup.getPairResultsAsString();
	}

	private List<List<Crew>> getShuffledCrewPairs(Course course) {
		List<Crew> crews = crewRepository.findAll(course);
		return pairMatcher.match(crews);
	}

	@Override
	public boolean isAlreadyMatched(MatchDto matchDto) {
		MatchGroup matchGroup = findMatchGroup(matchDto);
		return matchGroup.isAlreadyMatched();
	}

	@Override
	public boolean isNotAlreadyMatched(MatchDto matchDto) {
		return !isAlreadyMatched(matchDto);
	}

	private MatchGroup findMatchGroup(MatchDto matchDto) {
		Course course = matchDto.getCourse();
		Level level = matchDto.getLevel();
		String missionName = matchDto.getMissionName();
		return matchGroupRepository.findOne(course, level, missionName);
	}

	@Override
	public List<String> getPairResultOfMatchGroup(MatchDto matchDto) {
		MatchGroup matchGroup = findMatchGroup(matchDto);
		return matchGroup.getPairResultsAsString();
	}

	public void resetMatchGroups() {
		matchGroupRepository.reset();
	}

}
