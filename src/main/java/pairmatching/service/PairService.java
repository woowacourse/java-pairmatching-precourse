package pairmatching.service;

import pairmatching.domain.Category;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.enumeration.Course;
import pairmatching.domain.enumeration.Level;
import pairmatching.domain.enumeration.Mission;
import pairmatching.domain.Pairs;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;
import pairmatching.utils.ConstantMessages;
import pairmatching.utils.validator.InputValidator;

import java.util.List;

public class PairService {

    public static String[] validateInput(String input) {
        String[] inputArr = input.split(ConstantMessages.DELIMITER);
        InputValidator.validateCourseLevelMissionInput(inputArr);
        return inputArr;
    }

    public static Pairs createPairs(String[] input) {
        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
        Level level = getLevel(input[ConstantMessages.LEVEL_INDEX]);
        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
        int count = ConstantMessages.COUNT_DEFAULT;
        List<Crew> crews = null;
        crews = matchPair(course, level, mission, count);
        return addLastCrew(course, mission, crews);
    }

    public static boolean isMissionAlreadyHasPair(String[] input) {
        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
        if(PairRepository.findByCategory(new Category(mission, course)) != null) {
            return true;
        }
        return false;
    }

    public static Pairs findPairs(String[] input) {
        Course course = getCourse(input[ConstantMessages.COURSE_INDEX]);
        Mission mission = getMission(input[ConstantMessages.MISSION_INDEX]);
        return PairRepository.findByCategory(new Category(mission, course));
    }

    public static void resetPairs() {
        PairRepository.removeAll();
    }

    private static List<Crew> matchPair(Course course, Level level, Mission mission, int count) {
        List<Crew> crews;
        while(true) {
            crews = CrewRepository.shuffleCrew(course);
            Pairs pairs = new Pairs();
            if(isCreatePairsSuccess(level, course, crews, pairs)){
                PairRepository.createPairs(new Category(mission, course), pairs);
                break;
            }
            count = checkCount(count);
        }
        return crews;
    }

    private static int checkCount(int count) {
        count++;
        validateCount(count);
        return count;
    }

    private static Mission getMission(String s) {
        return Mission.findMissionByInput(s
                    .substring(ConstantMessages.SPACING));
    }

    private static Level getLevel(String s) {
        return Level.findLevelByInput(s
                    .substring(ConstantMessages.SPACING));
    }

    private static Course getCourse(String input1) {
        return Course.findCourseByInput(input1);
    }

    private static Pairs addLastCrew(Course course, Mission mission, List<Crew> crews) {
        Pairs findPairs = PairRepository.findByCategory(new Category(mission, course));
        if(isCrewSizeOddNumber(crews)) {
            int lastCrewIndex = crews.size() - 1;
            Crew crew = crews.get(lastCrewIndex);
            findPairs.addLastMember(crew);
        }
        return findPairs;
    }

    private static void validateCount(int count) {
        if(count == ConstantMessages.MAX_COUNT) {
            throw new IllegalArgumentException(ConstantMessages.PREFIX_ERROR + ConstantMessages.ERROR_FAIL_CREATE_PAIR);
        }
    }

    private static boolean isCreatePairsSuccess(Level level, Course course, List<Crew> crews, Pairs pairs) {
        for (int i = 0; i < crews.size() - 1; i = i+2) {
            Pair pair = getPair(crews, i);
            List<Mission> missionListByLevel = level.getMissionList();
            if (isLevelAlreadyHasPair(pair, course, missionListByLevel)) {
                return false;
            }
            pairs.addPair(pair);
        }
        return true;
    }

    private static Pair getPair(List<Crew> crews, int i) {
        Pair pair = new Pair();
        pair.addCrew(crews.get(i));
        pair.addCrew(crews.get(i +1));
        return pair;
    }

    private static boolean isLevelAlreadyHasPair(Pair pair, Course course, List<Mission> missionListByLevel) {
        for (int j = 0; j < missionListByLevel.size(); j++) {
            Pairs findPairs = PairRepository.findByCategory(new Category(missionListByLevel.get(j), course));
            if(findPairs == null) {
                continue;
            }
            if (isPairAlreadyExist(pair, findPairs)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPairAlreadyExist(Pair pair, Pairs findPairs) {
        if (findPairs.getPairList().contains(pair)) {
            return true;
        }
        return false;
    }

    private static boolean isCrewSizeOddNumber(List<Crew> crews) {
        if(crews.size() % 2 != 0) {
            return true;
        }
        return false;
    }

}
