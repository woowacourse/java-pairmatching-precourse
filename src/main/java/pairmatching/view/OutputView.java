package pairmatching.view;

import java.util.Set;
import pairmatching.domain.Pair;
import pairmatching.view.io.Printer;

public class OutputView {
    private static final Printer printer = new Printer();

    public void printMatchingResult(Set<Pair> pairs){
        printer.printMessage("");
        printer.printMessage("페어 매칭 결과입니다.");
        pairs.stream()
                .map(Pair::getCrews)
                .map(crew -> String.join(" : ", crew))
                .forEach(System.out::println);
        printer.printMessage("");
    }
}
