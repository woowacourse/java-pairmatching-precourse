package pairmatching.controller;

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
            else if (menu == 2) {
                pairController.select();
            }
            else if (menu == 3) {
                pairController.clear();
            }
        } while (menu != 0);
    }
}
