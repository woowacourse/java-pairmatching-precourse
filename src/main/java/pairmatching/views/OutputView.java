package pairmatching.views;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.LevelMisson;
import pairmatching.domain.LevelMissonRepository;
import pairmatching.enums.Course;

public class OutputView {
    private static final String HEADER_FOOTER = "#############################################";
    public static void printSection() {
        printHeaderOrFooter();
        printCourse();
        printLevel();
        printHeaderOrFooter();
    }

    public static void printCourse() {
        System.out.print("과정: ");
        System.out.println(String.join(" | ", Course.getNames()));
    }

    public static void printLevel() {
        System.out.println("미션:");
        List<LevelMisson> levelMissonList = LevelMissonRepository.getLevelMissonList();

        for(LevelMisson levelMisson : levelMissonList) {
            System.out.print("  -" + levelMisson.getLevel().getName() + ": ");
            System.out.println(String.join(" | ", levelMisson.getMissons()));
        }
    }

    public static void printHeaderOrFooter() {
        System.out.println(HEADER_FOOTER);
    }

    public static void printPairResult(List<List<String>> pairs) {
        System.out.println("페어 매칭 결과입니다.");
        for(List<String> pair : pairs) {
            System.out.println(String.join(" : ", pair));
        }
    }
}
