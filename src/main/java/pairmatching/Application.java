package pairmatching;

import static pairmatching.view.InputView.inputCommandIsNo;

import java.util.List;
import pairmatching.domain.Command;
import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Match;
import pairmatching.domain.Mission;
import pairmatching.domain.PairProgram;
import pairmatching.exception.MissionNotFoundMatchException;
import pairmatching.exception.OverMatchingException;
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

        runPairProgram(pairProgram);
    }

    private static void runPairProgram(PairProgram pairProgram) {
        Command command = inputCommand();
        if (command.isEndGame()) {
            return;
        }
        if (command.isMatching()) {
            InputView.printCurrentBoard(pairProgram.coures(), pairProgram.missions());
            OutputView.printMatchResult(matching(pairProgram));
        }
        if (command.isSelect()) {
            InputView.printCurrentBoard(pairProgram.coures(), pairProgram.missions());
            OutputView.printMatchResult(findMatching(pairProgram));
        }
        if (command.isInit()) {
            pairProgram.clearPairMatching();
            OutputView.printInit();
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

    private static List<Match> matching(PairProgram pairProgram) {
        try {
            List<String> matchingInformation = InputView.inputCourseAndLevelAndMission();
            Course course = Course.getCourse(matchingInformation.get(0));
            Level level = Level.getLevel(matchingInformation.get(1));
            String missionName = matchingInformation.get(2);
            Mission mission = Mission.createEmptyMission(missionName, course);
            if (pairProgram.isMatched(level, mission) && inputCommandIsNo(InputView.inputAlreadyMatching())) {
                matching(pairProgram);
            }
            return pairProgram.matching(level, mission);
        } catch (IllegalArgumentException | OverMatchingException e) {
            OutputView.printErrorMessage(e.getMessage());
            return matching(pairProgram);
        }
    }

    private static List<Match> findMatching(PairProgram pairProgram) {
        try {
            List<String> matchingInformation = InputView.inputCourseAndLevelAndMission();
            Course course = Course.getCourse(matchingInformation.get(0));
            Level level = Level.getLevel(matchingInformation.get(1));
            String missionName = matchingInformation.get(2);
            Mission mission = Mission.createEmptyMission(missionName, course);
            return pairProgram.findMatch(level, mission);
        } catch (IllegalArgumentException | MissionNotFoundMatchException e) {
            OutputView.printErrorMessage(e.getMessage());
            return findMatching(pairProgram);
        }
    }
}
