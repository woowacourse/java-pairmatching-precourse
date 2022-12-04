package pairmatching.outputview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MatchingResultOutputView implements OutputView {
    public static final String SEPARATOR_FORMAT = " %s ";
    public static final String VALUE_SEPARATOR = ":";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println("페어 매칭 결과입니다.");
        for (List<String> matchedPairNames : (List<List<String>>) model.get("matchedPairNames")) {
            printValues(matchedPairNames);
        }
    }

    private void printValues(List<String> values) {
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                addSeparator();
            }
        }
        System.out.println();
    }

    private void addSeparator() {
        System.out.printf(SEPARATOR_FORMAT, VALUE_SEPARATOR);
    }
}
