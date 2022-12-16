package pairmatching.controller;

import pairmatching.domain.MissionPair;
import pairmatching.domain.match.MatchData;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import static pairmatching.util.Constants.*;

public class PairController extends Controller {

    private boolean gameRun = true;
    private final PairService pairService = new PairService();

    public PairController(InputView inputView, OutputView outputView) {
        super(inputView, outputView);
    }

    @Override
    public void run() {
        start();
    }

    private void start() {
        while (gameRun) {
            String function = readFunction();
            doFunction(function);
        }
    }

    private String readFunction() {
        String func = repeat(inputView::readFunction);
        return func;
    }

    public void doFunction(String func) {
        if (func.equals(FUNC_MATCH)) {
            match();
        } else if (func.equals(FUNC_SHOW)) {
            show();
        } else if (func.equals(FUNC_RESET)) {
            reset();
        } else if (func.equals(FUNC_QUIT)) {
            gameRun = false;
        }
    }

    private void show() {
        MissionPair missionPair = findPair();
        outputView.printMissionPairs(missionPair);
    }

    private MissionPair findPair() {
        MissionPair missionPair;
        try {
            missionPair = pairService.findMissionPair(readMatchData());
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            missionPair = findPair();
        }
        return missionPair;
    }

    private void match() {
        MatchData matchData = readMatchData();
        MissionPair missionPair = pairService.matchMissionPair(matchData);
        outputView.printMissionPairs(missionPair);
    }

    private void reset() {
        pairService.resetMissionPair();
        outputView.printMissionPairsResetMessage();
    }

    private MatchData readMatchData() {
        MatchData matchData = repeat(inputView::readMatchData);
        return matchData;
    }
}
