package pairmatching.domain.dto;

import java.util.List;

public class MatchingResultDto {

    private final List<List<String>> matchingResult;

    public MatchingResultDto(List<List<String>> matchingResult) {
        this.matchingResult = matchingResult;
    }

    public List<List<String>> getMatchingResult() {
        return matchingResult;
    }
}

