package controller;

import static view.InputView.getMainSelect;

public class MainController {
    private boolean flag = false;

    public void run() {
        mainSelect();
    }
    private void mainSelect() {
        while(!flag) {
            try {
                String input = getMainSelect();
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
