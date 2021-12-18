package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchInfo;
import pairmatching.domain.Mission;
import pairmatching.repository.MatchInfoRepository;

import static pairmatching.controller.MatchingController.missions;
import static pairmatching.utils.ExceptionMessage.ERROR_NOT_EXIST_MATCH;
import static pairmatching.utils.Validator.checkInfoCount;
import static pairmatching.view.OutputViews.printMatchPair;

public class InqueryService {
    private static final MatchInfoRepository matchingInfoRepository = MatchInfoRepository.getInstance();
    public static final MatchingSercive matchingService = new MatchingSercive();

    public MatchInfo getMatchInfo(String input) {
        String[] infoArr = input.split(", ");
        checkInfoCount(infoArr);
        Course course = matchingService.checkCourse(infoArr[0]);
        Level level = matchingService.checkLevel(infoArr[1]);
        Mission mission = matchingService.checkMission(infoArr[1], infoArr[2], missions);
        try {
            return matchingInfoRepository.findMatchInfo(course, level, mission);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_MATCH);
        }

    }

}
