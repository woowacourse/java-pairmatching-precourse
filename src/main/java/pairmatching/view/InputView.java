package pairmatching.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.PairMission;
import pairmatching.domain.command.MainCommand;

public class InputView {

    private InputView() {
    }

    public static MainCommand mainCommand() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        MainCommand mainCommand = MainCommand.parseMainCommand(Console.readLine());
        System.out.println();
        return mainCommand;
    }

    public static PairMission pairMission() {
        StringBuilder stringBuilder = new StringBuilder("#############################################\n");
        stringBuilder.append("과정: ")
            .append(getCourseMessage()).append("\n")
            .append("미션: ").append("\n")
            .append(getLevelByMission()).append("\n")
            .append("#############################################").append("\n")
            .append("과정, 레벨, 미션을 선택하세요.").append("\n")
            .append("ex) 백엔드, 레벨1, 자동차경주");

        System.out.println(stringBuilder);

        return new PairMission(Console.readLine());
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