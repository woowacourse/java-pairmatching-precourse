package pairmatching;

import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;

public class Application {

    public static void main(String[] args) {
        Crews crews = Crews.init();
        crews.addBackEndCrews(InputView.inputBackEndCrews());
        crews.addFrontEndCrews(InputView.inputFrondEndCrews());

        PairProgram pairProgram = PairProgram.createPairProgram(crews);
        pairProgram.addMissions(Level.LEVEL1, InputView.inputFirstLevelMission());
        pairProgram.addMissions(Level.LEVEL2, InputView.inputSecondLevelMission());
        pairProgram.addMissions(Level.LEVEL3, InputView.inputThirdLevelMission());
        pairProgram.addMissions(Level.LEVEL4, InputView.inputFourthLevelMission());
        pairProgram.addMissions(Level.LEVEL5, InputView.inputFifthLevelMission());
    }
}
