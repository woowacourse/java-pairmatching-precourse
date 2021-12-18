package pairmatching.service;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.MatchInfo;
import pairmatching.model.Mission;
import pairmatching.repository.PairRepository;

import java.util.Arrays;
import java.util.List;

public class PairService {
    private static final String MATCHING_INPUT_REGEX = "[ ,]+";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String INVALID_COURSE_NAME = "존재하지 않는 과정입니다.";
    private static final String INVALID_LEVEL_NAME = "존재하지 않는 레벨입니다.";
    private static final String INVALID_MISSION_NAME = "존재하지 않는 미션입니다.";
    private static final int NOT_EXIST = 1;

    public void createMatching(String input) {
        MatchInfo matchInfo = getMatchInfo(input);
    }


    public boolean pairsExist(String input) {
        MatchInfo matchInfo = getMatchInfo(input);
        return PairRepository.countPairsByAll(matchInfo.getCourse(), matchInfo.getLevel(), matchInfo.getMission())
                != NOT_EXIST;
    }

    private MatchInfo getMatchInfo(String input) {
        List<String> matchingInput = Arrays.asList(input.split(MATCHING_INPUT_REGEX));
        Course course = PairRepository.findCourseByName(matchingInput.get(COURSE_INDEX)).orElseThrow(
                () -> new IllegalArgumentException(INVALID_COURSE_NAME));
        Level level = PairRepository.findLevelByName(matchingInput.get(LEVEL_INDEX)).orElseThrow(
                () -> new IllegalArgumentException(INVALID_LEVEL_NAME));
        Mission mission = PairRepository.findMissionByName(matchingInput.get(MISSION_INDEX)).orElseThrow(
                () -> new IllegalArgumentException(INVALID_MISSION_NAME));

        return new MatchInfo(course, level, mission);
    }
}
