package pairmatching.domain;

import java.util.*;
import java.io.*;

public class MatchingHistory {
    private static MatchingHistory instance = null;
    private Map<String, List<Crew>> matchingResults;

    private MatchingHistory() {
        this.matchingResults = new HashMap<>();
    }

    public static MatchingHistory of() {
        if (instance == null) {
            instance = new MatchingHistory();
        }
        return instance;
    }

    public void recordMatchingResult(String processInfo, List<Crew> crews) {
        matchingResults.put(processInfo, crews);
    }

    public boolean isMatchingExist(String processInfo) {
        return matchingResults.containsKey(processInfo);
    }

    public List<Crew> getMatchingResult(String processInfo) {
        return matchingResults.get(processInfo);
    }

    public void deleteMatchingResult(String processInfo) {
        matchingResults.remove(processInfo);
    }
}

