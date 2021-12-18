package pairmatching.service;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Level;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.enumeration.Pairs;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.utils.ConstantMessages;
import pairmatching.utils.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class PairService {

    private final PairRepository pairRepository;

    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    public Pairs matchPairs(String input) {
        String[] validInput = validateInput(input);
        Course course = Course.findCourseByInput(validInput[ConstantMessages.COURSE_INDEX]);
        Level level = Level.findLevelByInput(validInput[ConstantMessages.LEVEL_INDEX]
                .substring(ConstantMessages.SPACING));
        Mission mission = Mission.findMissionByInput(validInput[ConstantMessages.MISSION_INDEX]
                .substring(ConstantMessages.SPACING));
        int count = ConstantMessages.COUNT_DEFAULT;
        List<Crew> crews = null;
        while(true) {
            crews = CrewRepository.shuffleCrew(course);
            Pairs pairs = new Pairs();
            if(isCreatePairsSuccess(level, crews, pairs)){
                pairRepository.createPairs(mission, pairs);
                break;
            }
            count++;
            validateCount(count);
        }
        return addLastCrew(mission, crews);
    }

    private Pairs addLastCrew(Mission mission, List<Crew> crews) {
        Pairs findPairs = pairRepository.findByMission(mission);
        if(isCrewSizeOddNumber(crews)) {
            int lastCrewIndex = crews.size() - 1;
            Crew crew = crews.get(lastCrewIndex);
            findPairs.addLastMember(crew);
        }
        return findPairs;
    }

    private void validateCount(int count) {
        if(count == ConstantMessages.MAX_COUNT) {
            throw new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_FAIL_CREATE_PAIR);
        }
    }

    private boolean isCreatePairsSuccess(Level level, List<Crew> crews, Pairs pairs) {
        for (int i = 0; i < crews.size() - 1; i = i+2) {
            Pair pair = Pair.createPair(crews.get(i), crews.get(i+1));

            List<Mission> missionListByLevel = level.getMissionList();

            if (isLevelAlreadyHasPair(pair, missionListByLevel)) {
                return false;
            }
            pairs.addPair(pair);
        }
        return true;
    }

    private boolean isLevelAlreadyHasPair(Pair pair, List<Mission> missionListByLevel) {
        for (int j = 0; j < missionListByLevel.size(); j++) {
            Pairs findPairs = pairRepository.findByMission(missionListByLevel.get(j));
            if(findPairs == null) {
                continue;
            }
            if (isPairAlreadyExist(pair, findPairs)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPairAlreadyExist(Pair pair, Pairs findPairs) {
        if (findPairs.getPairList().contains(pair)) {
            return true;
        }
        return false;
    }

    private boolean isCrewSizeOddNumber(List<Crew> crews) {
        if(crews.size() % 2 != 0) {
            return true;
        }
        return false;
    }

    private String[] validateInput(String input) {
        String[] inputArr = input.split(ConstantMessages.DELIMITER);
        InputValidator.validateCourseLevelMissionInput(inputArr);
        return inputArr;
    }
}
