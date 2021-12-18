package pairmatching;

import pairmatching.domain.Crews;
import pairmatching.view.InputView;

public class Application {

    public static void main(String[] args) {
        Crews crews = Crews.init();
        crews.addBackEndCrews(InputView.inputBackEndCrews());
        crews.addFrontEndCrews(InputView.inputFrondEndCrews());
    }
}
