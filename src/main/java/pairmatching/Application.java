package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.MainView;

public class Application {
    public static void main(String[] args) {
        MainView mainView = new MainView(new PairMatchingController());
        while (!mainView.exited()) {
            mainView.select();
        }
    }
}
