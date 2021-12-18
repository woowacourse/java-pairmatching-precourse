package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;

import static pairmatching.domain.Level.*;
import static pairmatching.domain.Mission.*;

public class OutputView {

    private OutputView() {
    }

    public static String printFunctions() {
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");

        return Console.readLine();
    }

    public static String printCourseAndMission() {
        System.out.println("#############################################");
        System.out.print("과정: ");
        Course.printCourse();

        System.out.println("미션: ");
        System.out.println("\t- 레벨1: ");
        printMissionByLevel(LEVEL1);
        System.out.println("\t- 레벨2: ");
        printMissionByLevel(LEVEL2);
        System.out.println("\t- 레벨3: ");
        printMissionByLevel(LEVEL3);
        System.out.println("\t- 레벨4: ");
        printMissionByLevel(LEVEL4);
        System.out.println("\t- 레벨5: ");
        printMissionByLevel(LEVEL5);

        System.out.println("#############################################");

        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");

        return Console.readLine();
    }
}
