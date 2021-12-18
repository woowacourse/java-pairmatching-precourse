package pairmatching;

import java.util.List;

import pairmatching.controller.PairmatchingController;
import pairmatching.service.PairmatchingService;
import pairmatching.util.FileInputUtils;

public class Application {
    private static PairmatchingController pairmatchingController;

    public static void main(String[] args) {
        init();
        run();
    }

    private static void init() {
        pairmatchingController = new PairmatchingController();
    }

    private static void run() {
        pairmatchingController.run();
    }
}
