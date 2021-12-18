package pairmatching.view;

import static java.util.stream.Collectors.*;

import java.util.List;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInformation;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printPairMatchingResult(PairInformation pairInformation) {
        System.out.println("페어 매칭 결과입니다.");
        List<Pair> pairs = pairInformation.getPairs();
        for (Pair pair : pairs) {
            List<Crew> crews = pair.getCrews();
            String pairCrews = crews.stream().
                map(Crew::getName)
                .collect(joining(" : "));
            System.out.println(pairCrews);
        }
    }
}