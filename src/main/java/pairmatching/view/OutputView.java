package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.dto.CourseDto;
import pairmatching.dto.LevelDto;
import pairmatching.dto.PairDto;

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
            System.out.printf("  - %s: ", level.getName());
            System.out.println(String.join(" | ", level.getMissions()));
        });
        divideLine();
    }

    public static void printMatchingResult(List<PairDto> pairDtos) {
        System.out.println("페어 매칭 결과입니다.");
        pairDtos.forEach(dto -> {
            System.out.printf("%s : %s", dto.getFirstCrewName(), dto.getSecondCrewName());
            if (dto.getThirdCrewName() != null) {
                System.out.print(" : " + dto.getThirdCrewName());
            }
            emptyLine();
        });
    }

    private static void emptyLine() {
        System.out.println();
    }
}
