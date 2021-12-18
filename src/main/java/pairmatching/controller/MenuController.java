package pairmatching.controller;

import pairmatching.service.MenuService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MenuController {
    MenuService service = new MenuService();

    public int pickMenu() {
        try {
            return service.parseInput(InputView.inputMenu());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            pickMenu();
        }
        return 0;
    }
}
