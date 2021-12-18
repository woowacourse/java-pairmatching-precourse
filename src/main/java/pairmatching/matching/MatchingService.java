package pairmatching.matching;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchingService {
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

        }
    }

    public void initPeople() throws IOException {
        matchingFileInput = new MatchingFileInput();
        backendPeople = matchingFileInput.returnBackendPeople();
        frontendPeople = matchingFileInput.returnFrontendPeople();
    }

    public void checkValidCourseName(String courseName){
        if(!matching.checkRightCourseName(courseName)){
            throw new IllegalArgumentException();
        }
    }

    public boolean hasDistinctMatching(String courseName) {
        return matching.HasDuplicateMatchingBySameLevel(matching.getSameLevelIndexList(courseName));
    }

    public void hasAlreadyMatching(String courseName) {
        if (matching.alreadyHasMatching(courseName)) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> returnMatching(String courseName){
        return matching.getMatching(courseName);
    }

    public List<String> startMatching(String courseName) {
        if (courseName.contains(BACK_COURSE)) {
            List<String> matchingBackList = makeMatchingList(backendPeople);
            makeDistinctBackMatching(courseName, matchingBackList);
            return matchingBackList;
        }
        List<String> matchingFrontList = makeMatchingList(frontendPeople);
        makeDistinctFrontMatching(courseName, matchingFrontList);
        return matchingFrontList;
    }

    public boolean makeDistinctBackMatching(String courseName, List<String> matched){
        List<String> matchingList = makeMatchingList(backendPeople);
        // 랜덤 안되는 경우 검증로직
        matching.makeThisCourseMatching(courseName, matched);
        return true;
    }

    public boolean makeDistinctFrontMatching(String courseName, List<String> matched){
        List<String> matchingList = makeMatchingList(frontendPeople);
        // 랜덤 안되는 경우 검증로직
        matching.makeThisCourseMatching(courseName, matched);
        return true;
    }

    public List<String> makeMatchingList(List<String> originalPeople) {
        List<String> shufflePeople = Randoms.shuffle(originalPeople);
        List<String> matchingList = new ArrayList<>();
        int index = 0;
        for (index = 0; index < shufflePeople.size(); index += 2) {
            if (index == shufflePeople.size() - 3) {
                matchingList.add(shufflePeople.get(index) + " : " + shufflePeople.get(index + 1)
                        + " : " + shufflePeople.get(index + 2));
                break;
            }
            matchingList.add(shufflePeople.get(index) + " : " + shufflePeople.get(index + 1));
        }
        return matchingList;
    }
}
