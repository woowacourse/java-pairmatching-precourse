package pairmatching.domain;

import pairmatching.utils.OptionInputUtils;

import java.util.List;

import static pairmatching.constants.SystemConstants.OPTION_SEPARATOR;

public class MatchResult {

    private final Course course;
    private final Level level;
    private final Mission mission;
    private final List<Pair> pairs;

    public MatchResult(String optionsInput, List<Pair> pairs) {
        String[] optionInfos = optionsInput.split(OPTION_SEPARATOR);
        this.course = OptionInputUtils.courseNameToDomain(optionInfos[0]);
        this.level = OptionInputUtils.levelNameToDomain(optionInfos[1]);
        this.mission = MissionRepository.getMissionByName(optionInfos[2]);
        this.pairs = pairs;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
