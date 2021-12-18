package pairmatching;

import java.util.List;

import pairmatching.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        InputView inputView = new InputView();
        List<String> names = inputView.getFrontEndCrewNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
