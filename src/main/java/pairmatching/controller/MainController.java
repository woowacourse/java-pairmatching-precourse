package pairmatching.controller;

import static pairmatching.view.InputViews.getMainSelect;

public class MainController {
    public void run() {
        mainSelect();
    }

    private void mainSelect() {
        boolean flag = false;
        while (!flag) {
            try {
                String input = getMainSelect();
                // input 판별 기능 구현
                // input에 따른 결과 실행
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
