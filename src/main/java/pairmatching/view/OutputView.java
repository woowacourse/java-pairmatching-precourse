package pairmatching.view;

import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String MATCHING_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String COLON = " : ";

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + e.getMessage());
    }

    public static void printMatchingResult(List<Pair> pairs) {
        System.out.println(MATCHING_RESULT_MESSAGE);
        pairs.forEach(pair -> System.out.println(pair.getCrews().stream()
                .map(Crew::getName)
                .collect(Collectors.joining(COLON))));
    }
}
