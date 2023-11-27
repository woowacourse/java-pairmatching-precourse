package pairmatching.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Pair;

public class MatchingResultDto {

    public static List<List<String>> from(MatchingResult matchingResult) {
        List<Pair> pairs = matchingResult.getPairs();

        return pairs
                .stream()
                .map(pair -> pair.getCrews())
                .collect(Collectors.toList());
    }
}

