package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.*;
import pairmatching.util.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PairMatchingService {
    private PairMatching pairMatching;
    private MatchingHistory matchingHistory;

    public String getAllCourse() {
        return Course.getCourseName().stream().collect(Collectors.joining(Symbol.OR_SPACE));
    }

    public String getAllMission() {
        return Level.getLevelName().stream()
                .map(level -> Symbol.HYPHEN_TAB + level + Symbol.COLON + Symbol.SPACE +
                        Level.getMissionsName(level).stream()
                                .collect(Collectors.joining(Symbol.OR_SPACE)))
                .collect(Collectors.joining(Symbol.NEW_LINE));
    }

    public String getPariMatchingResult(String[] matchingInfo, List<Crew> crew) {
        matchPair(crew);
        return "";
    }

    private Pairs matchPair(List<Crew> crews) {
        List<Crew> shuffledCrew = Randoms.shuffle(crews);
        List<Pair> pairs = new ArrayList<>();

        for (int i=1; i<shuffledCrew.size(); i+=2) {
            pairs.add(Pair.from(shuffledCrew.get(i-1), shuffledCrew.get(i)));
        }
        if (shuffledCrew.size() % 2 != 0) {

        }
        return new Pairs(pairs);
    }
}
