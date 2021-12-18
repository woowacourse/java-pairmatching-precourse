package pairmatching;

import java.util.*;

public class MessagePrinter {

    public static void printFunctions() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    public static void printMissions() {
        System.out.println("#############################################");
        printCourses();
        printLevelAndMissions();
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    private static void printCourses(){
        System.out.print("과정: ");
        System.out.println("백엔드 | 프론트엔드");
    }

    private static void printLevelAndMissions(){
        System.out.println("미션: ");
        for(Level l:Level.values()){
            l.printLevel();
        }
    }
}
