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
        System.out.println(input);
        playPairProgrammming(input);
    }

    public void playPairProgrammming(String input) {
        if(input.equals("1")) {
            game1();
            playView();
        }
        if(input.equals("2")) {
            game2();
            playView();
        }
        if(input.equals("3")) {
            game3();
            playView();
        }
        if(input.equals("Q")) {
            return;
        }
    }

    public String chooseMenu() {
        return Console.readLine();
    }

    public String checkInputNumAndPlay() {
        String input = "";
        try {
            input = chooseMenu();
            Validation.checkInputForm(input);
        }catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1,2,3,Q 중 하나를 입력해주세요");
            input = checkInputNumAndPlay();
        }
        return input;
    }

    public void game1() {
        System.out.println("1번게임 시작");
        System.out.println();
    }

    public void game2() {
        System.out.println("2번게임 시작");
        System.out.println();
    }

    public void game3() {
        System.out.println("3번게임 시작");
        System.out.println();
    }
}
