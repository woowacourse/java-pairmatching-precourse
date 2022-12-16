package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.match.Course;
import pairmatching.domain.match.MatchData;
import pairmatching.util.CrewParser;

import java.io.IOException;
import java.util.List;

import static pairmatching.util.Constants.*;

public class PairService {

    public void doFunction(String func, MatchData matchData) {
        if(func.equals(FUNC_MATCH)) {
            List<String> crews = matchPair(matchData);
            crews.forEach(crew -> System.out.println("name = " + crew));
        } else if (func.equals(FUNC_SHOW)) {

        } else if (func.equals(FUNC_RESET)) {

        } else if (func.equals(FUNC_QUIT)) {

        }
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
