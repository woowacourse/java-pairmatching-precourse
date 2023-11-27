package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import pairmatching.dto.MissionDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.matching.MatchingHistory;

public class MatchingService {

    private static MatchingHistory matchingHistory = new MatchingHistory();
    private static final CrewRepository crewRepository = new CrewRepository();
    private final CrewMatcher crewMatcher;

    public MatchingService(CrewMatcher crewMatcher) {
        this.crewMatcher = crewMatcher;
    }

    public boolean isMatched(MissionDto missionDto) {
        return matchingHistory.isMatched(missionDto);
    }

    public Set<Pair> matching(MissionDto dto){
        List<String> crewName = new ArrayList<>();

        if (dto.getCourse().equals("백엔드")) {
            crewName = crewRepository.getBackendCrewName();
        }
        if (dto.getCourse().equals("프론트엔드")) {
            crewName = crewRepository.getFrontendCrewNames();
        }
        for(int i = 0; i<3; i++){
            Set<Pair> pairs = crewMatcher.matching(crewName);
            if(!matchingHistory.isDuplicated(dto, pairs)){
                matchingHistory.save(dto, pairs);
                return pairs;
            }
        }

        throw new IllegalArgumentException("매칭에 실패했습니다.");
    }

    public void removeHistory(MissionDto missionDto) {
        matchingHistory.removeHistory(missionDto);
    }

    public Set<Pair> getResult(MissionDto missionDto) {
        return matchingHistory.getResult(missionDto);
    }

    public void reset() {
        matchingHistory = new MatchingHistory();
    }
}
