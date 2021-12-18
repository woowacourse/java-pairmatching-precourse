package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MatchingHistory;
import pairmatching.model.PairMatching;
import pairmatching.util.InputSign;
import pairmatching.util.Symbol;

import java.util.stream.Collectors;

public class PairMatchingService {
    private PairMatching pairMatching;
    private MatchingHistory matchingHistory;

    public boolean isQuit(String function) {
        return function.equals(InputSign.SIGN_QUIT);
    }

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
}
