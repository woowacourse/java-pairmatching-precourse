package pairmatching.view;

import pairmatching.domain.Course;
import pairmatching.domain.Matching;
import pairmatching.domain.MissionRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printCourseAndMission() {
        System.out.println("\n#############################################");
        List<String> course = Stream.of(Course.values()).map(c -> c.getName()).collect(Collectors.toList());
        System.out.println("과정: " + String.join(" | ", course));
        System.out.print("미션 : ");
        System.out.println(MissionRepository.print());
        System.out.println("#############################################");
    }

    public static void printPairs(Matching m) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(m.toString());
    }

    public static void printClear() {
        System.out.println("초기화 되었습니다.");
    }

}
