package pairmatching;

import pairmatching.domain.Command;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.PairProgram;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

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

        Command command = Command.init();
        runPairProgram(pairProgram);
    }

    private static void runPairProgram(PairProgram pairProgram) {
        Command command = inputCommand();
        if (command.isEndGame()) {
            return;
        }
        runPairProgram(pairProgram);
    }

    private static Command inputCommand() {
        try {
            return Command.getCommand(InputView.inputCommand(Command.commands()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return inputCommand();
        }
    }
}
