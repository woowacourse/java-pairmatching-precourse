package pairmatching.play;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.Validation;

public class PlayController {
    private PlayView playView;
    private PlayModel playModel;
    private String input;

    public PlayController() {
        playView = new PlayView();
        playModel = new PlayModel();
    }

    public void playGame() {
        playView.showMenuView();
        this.input = checkInputNumAndPlay();
        boolean result; // 게임이 끝나면 true 반환 후 종료
        while (true){
            result = playModel.playPairProgrammming(this.input);
            if(result){
                break;
            }
            playGame();
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
}
