package pairmatching;

import java.util.List;
import pairmatching.view.InputView;

public class Application {

    public static void main(String[] args) {
        List<String> backEndCrews = InputView.inputBackEndCrews();
        List<String> frontEndCrews = InputView.inputFrondEndCrews();
    }
}
