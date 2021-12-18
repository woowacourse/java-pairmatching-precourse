package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Mission;
import pairmatching.repository.MatchInfoRepository;

import static pairmatching.controller.MatchingController.missions;
import static pairmatching.utils.Constants.*;
import static pairmatching.utils.ExceptionMessage.ERROR_NOT_EXIST_MATCH;
import static pairmatching.utils.Validator.checkInfoCount;

public class InqueryService {
    private static final MatchInfoRepository matchingInfoRepository = MatchInfoRepository.getInstance();
    public static final MatchingSercive matchingService = new MatchingSercive();


    public MatchInfo getMatchInfo(String input) {
        String[] infoArr = input.split(ITEM_SEPORATOR);
        checkInfoCount(infoArr);
        Course course = matchingService.checkCourse(infoArr[COURSE_INDEX]);
        Level level = matchingService.checkLevel(infoArr[LEVEL_INDEX]);
        Mission mission = matchingService.checkMission(infoArr[LEVEL_INDEX], infoArr[MISSION_INDEX], missions);
        try {
            return matchingInfoRepository.findMatchInfo(course, level, mission);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_MATCH);
        }
    }
}
