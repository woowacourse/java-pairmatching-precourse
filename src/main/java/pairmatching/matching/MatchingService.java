package pairmatching.matching;

import pairmatching.ValidatorMessage;

import java.io.IOException;
import java.util.List;

public class MatchingService {
    private MatchingFileInput matchingFileInput;
    private final Matching matching;

    private List<String> backendPeople;
    private List<String> frontendPeople;

    public MatchingService() {
        matching = new Matching();
        try {
            initPeople();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e){

        }
    }

    public void initPeople() throws IOException {
        matchingFileInput = new MatchingFileInput();
        backendPeople = matchingFileInput.returnBackendPeople();
        frontendPeople = matchingFileInput.returnFrontendPeople();
    }

    public boolean hasDistinctMatching(String courseName) {
        return matching.HasDuplicateMatchingBySameLevel(matching.getSameLevelIndexList(courseName));
    }

//    public List<String> startMatching(String courseName) {
//
//    }
}
