package pairmatching.controller;

import pairmatching.view.OutputView;

public class MainController {
    InitController initController = new InitController();
    MenuController menuController = new MenuController();
    PairController pairController = new PairController();

    public void start() {
        initController.init();
        int menu;
        do {
            menu = menuController.pickMenu();
            if (menu == 1) {
                pairController.matching();
            }
            if(menu==2){
                pairController.select();
            }
        } while (menu != 0);
    }
}
