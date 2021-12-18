package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.InitialSetting;
import pairmatching.view.InputView;

public class PairController {
    private InputView inputView = new InputView();
    private InitialSetting initialSetting = new InitialSetting();

    public void run() {
        initialSetting.initialInformation();
        selectMenu();
    }

    public void selectMenu() {
        inputView.printSelectMenu();
        String selectMenu = Console.readLine();
        if (selectMenu.equals("1")) {
            pairMatch();
        }
        if (selectMenu.equals("2")) {
            getPair();
        }
        if (selectMenu.equals("3")) {
            initialPair();
        }
        if (selectMenu.equals("Q")) {
            return;
        }
    }

    public void pairMatch() {
        inputView.inputInformation();
    }

    public void getPair() {
        inputView.inputInformation();
    }

    public void initialPair() {

    }
}
