package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.MissionPair;
import pairmatching.domain.match.Course;
import pairmatching.domain.match.MatchData;
import pairmatching.repository.PairRepository;
import pairmatching.util.CrewParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.util.Constants.*;

public class PairService {

    private final PairRepository pairRepository = new PairRepository();

    public void doFunction(String func, MatchData matchData) {
        if(func.equals(FUNC_MATCH)) {
            List<String> crews = matchPair(matchData);
            MissionPair missionPair = makeMissionPair(matchData, crews);
            pairRepository.addMissionPair(missionPair);
        } else if (func.equals(FUNC_SHOW)) {

        } else if (func.equals(FUNC_RESET)) {

        } else if (func.equals(FUNC_QUIT)) {

        }
    }
    
    public MissionPair makeMissionPair(MatchData matchData, List<String> crews) {
        MissionPair missionPair = new MissionPair(matchData);
        List<Crew> crewPair = new ArrayList<>();
        for(int i = 0; i < crews.size(); i++) {
            if(i % 2 == 0 && i != 0) {
                missionPair.addPair(crewPair);
                crewPair = new ArrayList<>();
            }
            crewPair.add(new Crew(crews.get(i)));
            if(crews.size() % 2 == 1 && i == (crews.size()-2)) {
                crewPair.add(new Crew(crews.get(i+1)));
                missionPair.addPair(crewPair);
                break;
            }
        }
        return missionPair;
    }

    public List<String> matchPair(MatchData matchData) {
        List<String> crews = getCrews(matchData.getCourse());
        return crews;
    }

    public List<String> getCrews(Course course){
        CrewParser parser = new CrewParser();
        List<String> crews = parser.parseCrewData(course);
        return shuffleCrews(crews);
    }

    private List<String> shuffleCrews(List<String> crews) {
        return Randoms.shuffle(crews);
    }


}
