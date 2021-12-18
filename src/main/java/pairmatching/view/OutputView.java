package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.dto.CourseDto;
import pairmatching.dto.LevelDto;

public class OutputView {

    public static void printProcess(List<CourseDto> courses) {
        divideLine();
        String course = "과정: " + courses.stream().map(CourseDto::getName).collect(Collectors.joining(" | "));
        System.out.println(course);
    }


    private static void divideLine() {
        System.out.println("#############################################");
    }

    public static void printMission(List<LevelDto> levels) {
        System.out.println("미션:");
        levels.forEach(level -> {
            System.out.print(String.format("  - %s: ", level.getName()));
            System.out.println(String.join(" | ", level.getMissions()));
        });
        divideLine();
    }
}
