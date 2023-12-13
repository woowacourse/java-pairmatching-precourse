package pairmatching.view;

import static pairmatching.view.ViewMessage.*;

import java.util.StringJoiner;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;

public class OutputView {

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printSelectOption() {
        System.out.printf(SELECT_OPTION.getMessage());
    }

    public void printSelectCondition() {
        System.out.printf(INFO.getMessage());
    }

    public void printPairs(Pairs pairs) {
        System.out.printf(RESULT.getMessage());
        for (Pair pair : pairs.getPairs()) {
            StringJoiner result = new StringJoiner(RESULT_DELIMITER.getMessage());
            for (Crew crew : pair.getCrews()) {
                result.add(crew.getName());
            }
            System.out.println(result);
        }
    }

    public void printReset() {
        System.out.printf(RESET.getMessage());
    }

    public void printRematching() {
        System.out.printf(REMATCHING.getMessage());
    }
}
