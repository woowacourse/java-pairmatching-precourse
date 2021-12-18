package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.InitialSetting;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    private InputView inputView = new InputView();
    private InitialSetting initialSetting = new InitialSetting();
    private OutputView outputView = new OutputView();

    public void run() {
        initialSetting.initialInformation();
        initialSetting.getFileNameInDirectory();
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
        outputView.printInformation();
        inputView.inputInformation();
    }

    public void getPair() {
        outputView.printInformation();
        inputView.inputInformation();
    }

    public void initialPair() {

    }
}
