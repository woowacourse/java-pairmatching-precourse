package pairmatching.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInformation;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
        System.out.println();
    }

    public static void printMainCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
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
        System.out.println();
    }

    public static void printPairMission() {
        StringBuilder stringBuilder = new StringBuilder("#############################################\n");
        stringBuilder.append("과정: ")
            .append(getCourseMessage()).append("\n")
            .append("미션: ").append("\n")
            .append(getLevelByMission()).append("\n")
            .append("#############################################");
        System.out.println(stringBuilder);
    }

    private static String getCourseMessage() {
        return Arrays.stream(Course.values())
            .map(Course::getName)
            .collect(joining(" | "));
    }

    private static String getLevelByMission() {
        return Arrays.stream(Level.values())
            .map(level -> {
                StringBuilder stringBuilder = new StringBuilder();
                return stringBuilder.append("  - ")
                    .append(level.getName())
                    .append(": ")
                    .append(String.join(" | ", level.getMissions()))
                    .toString();
            }).collect(joining("\n"));
    }
}