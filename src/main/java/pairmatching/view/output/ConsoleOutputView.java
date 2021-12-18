package pairmatching.view.output;

import pairmatching.model.crew.CrewPair;

import java.util.List;
import java.util.StringJoiner;

public class ConsoleOutputView implements OutputView{
    private static final String PAIR_RESULT_MESSAGE = "페어 매칭 결과입니다.";
    private static final String CREW_DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    public void showMatchedCrews(final List<CrewPair> matchedCrews) {
        System.out.println(PAIR_RESULT_MESSAGE);
        StringBuilder result = new StringBuilder();
        for (CrewPair crewPair : matchedCrews) {
            List<String> names = crewPair.getNames();
            StringJoiner stringJoiner = new StringJoiner(CREW_DELIMITER);
            for (String name : names) {
                stringJoiner.add(name);
            }
            result.append(stringJoiner).append(NEW_LINE);
        }
        System.out.println(result);
    }
}
