package pairmatching.domain.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.Pair;

public class MatchingResultMapper {

    private MatchingResultMapper() {
    }

    public static MatchingResultDto from(MatchingResult matchingResult) {
        List<Pair> pairs = matchingResult.getPairs();
        List<List<String>> transformed =  pairs
                .stream()
                .map(pair -> pair.getCrews())
                .collect(Collectors.toList());

        return new MatchingResultDto(transformed);
    }

}
