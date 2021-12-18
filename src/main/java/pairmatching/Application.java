package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.controller.ViewMappingKey;

public class Application {
    public static PairMatchingController controller = new PairMatchingController();
    public static void main(String[] args) {
        // TODO 구현 진행
        controller.view(ViewMappingKey.FUNCTION_SELECT);
    }
}
