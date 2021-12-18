package pairmatching;

import java.io.IOException;

import pairmatching.controller.PairMatchingController;
import pairmatching.controller.ViewMappingKey;

public class Application {
    public static PairMatchingController controller;

    static {
        try {
            controller = new PairMatchingController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO 구현 진행
        controller.view(ViewMappingKey.FUNCTION_SELECT);
    }
}
