package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.*;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairService {
    private static final String MATCHING_INPUT_REGEX = "[ ,]+";
    private static final int COURSE_INDEX = 0;
    private static final int LEVEL_INDEX = 1;
    private static final int MISSION_INDEX = 2;
    private static final String INVALID_COURSE_NAME = "존재하지 않는 과정입니다.";
    private static final String INVALID_LEVEL_NAME = "존재하지 않는 레벨입니다.";
    private static final String INVALID_MISSION_NAME = "존재하지 않는 미션입니다.";
    private static final int NOT_EXIST = 1;

    public boolean tryMatching(String input) {
        boolean canMatch = true;
        MatchInfo matchInfo = getMatchInfo(input);
        List<String> crewNames = CrewRepository.getCrewNamesByCourse(matchInfo.getCourse());
        List<List<String>> pairNamesList = null;
        for (int i = 0; i < 3; i++) {
            List<String> shuffledCrew = Randoms.shuffle(crewNames);
            pairNamesList = createPairs(shuffledCrew, matchInfo.getLevel());
            if (!alreadyMetPair(pairNamesList, matchInfo.getLevel())) {
                canMatch = false;
                break;
            }
        }
        if (canMatch) {
            createMatching(pairNamesList, matchInfo);
            return true;
        }
        return false;
    }

    public void createMatching(List<List<String>> pairNamesList, MatchInfo matchInfo) {
        for (List<String> pairNames : pairNamesList) {
            List<Crew> crews = getCrewsByName(pairNames);
            PairRepository.addPair(crews, matchInfo);
        }
        System.out.println(PairRepository.pairs());
    }

    private List<List<String>> createPairs(List<String> shuffledCrew, Level level) {
        List<List<String>> pairNamesList = new ArrayList<>();
        for (int i = 0; i < shuffledCrew.size()-1; i = i + 2) {
            List<String> pairNames = new ArrayList<>();
            pairNames.add(shuffledCrew.get(i));
            pairNames.add(shuffledCrew.get(i+1));
            if (shuffledCrew.size() % 2 != 0 && i == shuffledCrew.size() - 3) {
                pairNames.add(shuffledCrew.get(i+2));
            }
            Collections.sort(pairNames);
            pairNamesList.add(pairNames);
        }
        return pairNamesList;
    }

    private boolean alreadyMetPair(List<List<String>> pairNamesList, Level level) {
        for (List<String> pairNames : pairNamesList) {
            List<Crew> crews = getCrewsByName(pairNames);
            if (PairRepository.alreadyMetPairInSameLevel(crews, level)) {
                return false;
            }
        }
        return true;
    }

    private List<Crew> getCrewsByName(List<String> pairNames) {
        return pairNames.stream()
                .map(CrewRepository::findByName)
                .collect(Collectors.toList());
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

    public List<Pair> getMatching(String input) {
        MatchInfo matchInfo = getMatchInfo(input);
        return PairRepository.findPairsByMatchInfo(matchInfo);
    }
}
