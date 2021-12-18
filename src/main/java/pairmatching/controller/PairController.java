package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.view.InputView;

public class PairController {
    private InputView inputView = new InputView();

    public void run() {
        selectMenu();
    }

    public void selectMenu() {
        inputView.printSelectMenu();
        String selectMenu = Console.readLine();
        if(selectMenu.equals("1")){
            pairMatch();
        }
        if(selectMenu.equals("2")){
            getPair();
        }
        if(selectMenu.equals("3")){
            initialPair();
        }
        if(selectMenu.equals("Q")){
            return;
        }
    }

    public void pairMatch() {

    }

    public void getPair() {

    }

    public void initialPair() {

    }
}
