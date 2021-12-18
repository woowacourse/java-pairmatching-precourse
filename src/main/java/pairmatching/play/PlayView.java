package pairmatching.play;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Validation;

public class PlayView {
    public void playView() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
        String input = checkInputNumAndPlay();
    }

    public String chooseMenu() {
        return Console.readLine();
    }

    public String checkInputNumAndPlay() {
        String input = chooseMenu();
        try {
            Validation.checkInputForm(input);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1,2,3,Q 중 하나를 입력해주세요");
            checkInputNumAndPlay();
        }
        return input;
    }
}
