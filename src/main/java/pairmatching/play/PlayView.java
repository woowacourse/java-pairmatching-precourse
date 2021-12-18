package pairmatching.play;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Validation;

import static pairmatching.course.Level.*;

public class PlayView {
    public void showMenuView() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    public void num1InputView() {
        System.out.println("#############################################");
        System.out.println("과정 : 백엔드 | 프론트엔드");
        System.out.println("미션 :");
        System.out.println(LEVEL1.toString());
        System.out.println(LEVEL2.toString());
        System.out.println(LEVEL3.toString());
        System.out.println(LEVEL4.toString());
        System.out.println(LEVEL5.toString());
        System.out.println("#############################################");
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
    }

    public String inputString() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
