package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.MissionPair;
import pairmatching.domain.match.Course;
import pairmatching.domain.match.MatchData;
import pairmatching.repository.PairRepository;
import pairmatching.util.CrewParser;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.util.Validator.ERROR_PREFIX;

public class PairService {

    private final PairRepository pairRepository = new PairRepository();


    public MissionPair doPairMatchingFunction(MatchData matchData) {
        List<String> crews = matchPair(matchData);
        MissionPair missionPair = makeMissionPair(matchData, crews);
        return pairRepository.addMissionPair(missionPair);
    }

    public MissionPair makeMissionPair(MatchData matchData, List<String> crews) {
        MissionPair missionPair = new MissionPair(matchData);
        List<Crew> crewPair = new ArrayList<>();
        for (int i = 0; i < crews.size(); i++) {
            crewPair.add(new Crew(crews.get(i)));
            if (crews.size() % 2 == 1 && i == (crews.size() - 2)) {
                crewPair.add(new Crew(crews.get(i + 1)));
                missionPair.addPair(crewPair);
                break;
            }
            if (i % 2 == 1) {
                missionPair.addPair(crewPair);
                crewPair = new ArrayList<>();
            }
        }
        return missionPair;
    }

    public MissionPair findMissionPair(MatchData matchData) {
        return pairRepository.findMissionPair(matchData)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "매칭 이력이 없습니다."));

    }

    public void resetMissionPair() {
        pairRepository.reset();
    }

    private List<String> matchPair(MatchData matchData) {
        List<String> crews = getCrews(matchData.getCourse());
        return crews;
    }

    private List<String> getCrews(Course course) {
        CrewParser parser = new CrewParser();
        List<String> crews = parser.parseCrewData(course);
        return shuffleCrews(crews);
    }

    private List<String> shuffleCrews(List<String> crews) {
        return Randoms.shuffle(crews);
    }


}
