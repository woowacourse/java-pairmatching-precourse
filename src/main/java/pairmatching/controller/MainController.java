package pairmatching.controller;

public class MainController {
    public static MainController instance;

    public static MainController getInstance() {
        if (instance == null) {
            instance = new MainController();
        }
        return instance;
    }

    public void run() {
        initMain();
    }

    private void initMain() {
    }
}
