package pairmatching.domain;

import pairmatching.utils.OptionInputUtils;

import java.util.ArrayList;
import java.util.List;

import static pairmatching.constants.SystemConstants.OPTION_SEPARATOR;

public class MatchResultRepository {

    private static final List<MatchResult> matchResults = new ArrayList<>();

    public static MatchResult getMatchResultByOptions(String options) {
        String[] optionInfos = options.split(OPTION_SEPARATOR);
        Course course = OptionInputUtils.courseNameToDomain(optionInfos[0]);
        Level level = OptionInputUtils.levelNameToDomain(optionInfos[1]);
        Mission mission = MissionRepository.getMissionByName(optionInfos[2]);

        for (MatchResult matchResult : matchResults) {
            if (course != matchResult.getCourse()) continue;
            if (level != matchResult.getLevel()) continue;
            if (mission != matchResult.getMission()) continue;
            return matchResult;
        }
        return null;
    }

    public static void addMatchResult(MatchResult matchResult) {
        matchResults.add(matchResult);
    }

    public static void deleteMatchResults() { matchResults.clear(); }
}
