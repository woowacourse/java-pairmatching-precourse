package pairmatching;

import java.util.stream.Collectors;

public class Printer {

    private static final String ERROR_SIGN = "[ERROR]";

    public void printInfoMessage(InfoMessage infoMessage) {
        System.out.println(infoMessage.getMessage());
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(ERROR_SIGN + exception.getMessage());
    }

    public void printResult(Result result) {

        System.out.println("페어 매칭 결과입니다.");
        for (Pair pair : result.getPairs()) {
            String names = pair.getCrewsOfPair().stream()
                .map(Crew::getName)
                .collect(Collectors.joining(" : "));
            System.out.println(names);
        }

    }

}
