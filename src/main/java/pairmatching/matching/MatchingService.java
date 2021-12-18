package pairmatching.matching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.ValidatorMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private static final int MATCHING_MAX_SIZE = 3;
    private static final int MATCHING_ODD_MAX_SIZE = 3;
    private static final int MATCHING_NORMAL_SIZE = 2;

    private final String BACK_COURSE = "백엔드";
    private final String FRONT_COURSE = "프론트엔드";

    private final Matching matching;
    private MatchingFileInput matchingFileInput;
    private List<String> backendPeople;
    private List<String> frontendPeople;

    public MatchingService() {
        matching = new Matching();
        try {
            initPeople();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            ValidatorMessage.printError(ValidatorMessage.ERROR_MESSAGE + ValidatorMessage.NOT_EXIST_FILE);
        }
    }

    public void initPeople() throws IOException {
        matchingFileInput = new MatchingFileInput();
        backendPeople = matchingFileInput.returnBackendPeople();
        frontendPeople = matchingFileInput.returnFrontendPeople();
    }

    public void checkValidCourseName(String courseName) {
        if (!matching.checkRightCourseName(courseName)) {
            throw new IllegalArgumentException();
        }
    }

    public void hasAlreadyMatching(String courseName) {
        if (matching.alreadyHasMatching(courseName)) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> returnMatching(String courseName) {
        return matching.getMatching(courseName);
    }

    public List<String> startMatching(String courseName) {
        if (courseName.contains(BACK_COURSE)) {
            List<String> matchingBackList = makeMatchingList(backendPeople);
            makeDistinctMatching(courseName, matchingBackList);
            return matchingBackList;
        }
        List<String> matchingFrontList = makeMatchingList(frontendPeople);
        makeDistinctMatching(courseName, matchingFrontList);
        return matchingFrontList;
    }

    public void makeDistinctMatching(String courseName, List<String> matched) {
        for (int i = 0; i < MATCHING_MAX_SIZE; i++) {
            matching.makeThisCourseMatching(courseName, matched);
            if (!matching.HasDuplicateMatchingBySameLevel(courseName)) {
                return;
            }
            matching.makeThisCourseMatching(courseName, new ArrayList<>());
        }
        throw new IllegalArgumentException();
    }

    public List<String> makeMatchingList(List<String> originalPeople) {
        List<String> shufflePeople = Randoms.shuffle(originalPeople);
        List<String> matchingList = new ArrayList<>();
        for (int index = 0; index < shufflePeople.size(); index += MATCHING_NORMAL_SIZE) {
            if (index == shufflePeople.size() - MATCHING_ODD_MAX_SIZE) {
                matchingList.add(shufflePeople.get(index) + " : " + shufflePeople.get(index + 1)
                        + " : " + shufflePeople.get(index + 2));
                break;
            }
            matchingList.add(shufflePeople.get(index) + " : " + shufflePeople.get(index + 1));
        }
        return matchingList;
    }

    public void initAllMatching() {
        matching.initCourseMatching();
    }
}
