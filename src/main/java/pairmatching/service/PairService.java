package pairmatching.service;

import pairmatching.domain.Category;
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

import java.util.List;

public class PairService {

    private final PairRepository pairRepository;

    public PairService(PairRepository pairRepository) {
        this.pairRepository = pairRepository;
    }

    public String[] validateInput(String input) {
        String[] inputArr = input.split(ConstantMessages.DELIMITER);
        InputValidator.validateCourseLevelMissionInput(inputArr);
        return inputArr;
    }

    public Pairs createPairs(String[] input) {
        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
        Level level = getLevel(input[ConstantMessages.LEVEL_INDEX]);
        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
        int count = ConstantMessages.COUNT_DEFAULT;
        List<Crew> crews = null;
        crews = matchPair(course, level, mission, count);
        return addLastCrew(course, mission, crews);
    }

    public boolean isMissionAlreadyHasPair(String[] input) {
        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
        if(pairRepository.findByCategory(new Category(mission, course)) != null) {
            return true;
        }
        return false;
    }

//    public Pairs findPairs(String[] input) {
//        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
//        Level level = getLevel(input[ConstantMessages.LEVEL_INDEX]);
//        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
//    }

    private List<Crew> matchPair(Course course, Level level, Mission mission, int count) {
        List<Crew> crews;
        while(true) {
            crews = CrewRepository.shuffleCrew(course);
            Pairs pairs = new Pairs();
            if(isCreatePairsSuccess(level, course, crews, pairs)){
                pairRepository.createPairs(new Category(mission, course), pairs);
                break;
            }
            count = checkCount(count);
        }
        return crews;
    }

    private int checkCount(int count) {
        count++;
        validateCount(count);
        return count;
    }

    private Mission getMission(String s) {
        return Mission.findMissionByInput(s
                    .substring(ConstantMessages.SPACING));
    }

    private Level getLevel(String s) {
        return Level.findLevelByInput(s
                    .substring(ConstantMessages.SPACING));
    }

    private Course getCourse(String input1) {
        return Course.findCourseByInput(input1);
    }

    private Pairs addLastCrew(Course course, Mission mission, List<Crew> crews) {
        Pairs findPairs = pairRepository.findByCategory(new Category(mission, course));
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

    private boolean isCreatePairsSuccess(Level level, Course course, List<Crew> crews, Pairs pairs) {
        for (int i = 0; i < crews.size() - 1; i = i+2) {
            Pair pair = Pair.createPair(crews.get(i), crews.get(i+1));
            List<Mission> missionListByLevel = level.getMissionList();
            if (isLevelAlreadyHasPair(pair, course, missionListByLevel)) {
                return false;
            }
            pairs.addPair(pair);
        }
        return true;
    }

    private boolean isLevelAlreadyHasPair(Pair pair, Course course, List<Mission> missionListByLevel) {
        for (int j = 0; j < missionListByLevel.size(); j++) {
            Pairs findPairs = pairRepository.findByCategory(new Category(missionListByLevel.get(j), course));
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

}
