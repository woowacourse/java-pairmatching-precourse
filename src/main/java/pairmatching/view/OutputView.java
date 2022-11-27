package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Course;
import pairmatching.Level;
import pairmatching.Missions;

public class OutputView {
    public void printSelectFunction() {
        System.out.println("기능을 선택하세요. \n" +
                "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료");
    }
    public static void printCourseAndMission(Missions missions) {
        System.out.println("#############################################" +
                "과정: \n");
                System.out.println(String.join(" | ", Course.getList()));
                for (Level level : Level.getList()) {
                    System.out.print(" -" + level.getName() + ":");
                    System.out.println(String.join(" | ", missions.getValue(level)));
                }
                System.out.println("#############################################\n");
    }
}
