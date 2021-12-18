package pairmatching;

import static pairmatching.ErrorMessage.EMPTY_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Machine {

    private final String FRONTEND = "프론트엔드";
    private final String BACKEND = "백엔드";
    private final String YES_SIGN = "네";
    private final String SEPARATOR = ", ";
    private final String MAKE_PAIR = "1";
    private final String SEARCH = "2";
    private final String RENEW = "3";
    private final String QUIT = "Q";
    private final int COURSE = 0;
    private final int LEVEL = 1;
    private final int MISSION = 2;
    private final int MISSION_QUANTITY = 8;
    private final int PAIR_SIZE = 2;

    private Input input = new Input();
    private Printer printer = new Printer();
    private List<Crew> backendCrews;
    private List<Crew> frontendCrews;
    private Result[] backendResults = new Result[MISSION_QUANTITY];
    private Result[] frontendResults = new Result[MISSION_QUANTITY];

    public Machine(List<Crew> backendCrews, List<Crew> frontendCrews) {
        this.backendCrews = backendCrews;
        this.frontendCrews = frontendCrews;
    }

    public void run() {
        String chooseFunction = "";

        while (!chooseFunction.equals(QUIT)) {
            printer.printInfoMessage(InfoMessage.FUNCTION_INPUT_MESSAGE);
            chooseFunction = input.inputChooseFunction();
            if (chooseFunction.equals(MAKE_PAIR)) {
                makePair();
            }
            if (chooseFunction.equals(SEARCH)) {
                search();
            }
            if (chooseFunction.equals(RENEW)) {
                renew();
            }
        }
    }

    private void makePair() {
        printer.printInfoMessage(InfoMessage.COURSE_LEVEL_MISSION_MESSAGE);
        String input = this.input.inputCourseLevelMission();
        String[] splitedInput = input.split(SEPARATOR);

        if (splitedInput[COURSE].equals(FRONTEND)) {
            runFrontendMakePairLogic(splitedInput[LEVEL], splitedInput[MISSION]);
        }
        if (splitedInput[COURSE].equals(BACKEND)) {
            runBackEndMakePairLogic(splitedInput[LEVEL], splitedInput[MISSION]);
        }
    }

    private void search() throws IllegalArgumentException {
        printer.printInfoMessage(InfoMessage.COURSE_LEVEL_MISSION_MESSAGE);
        String input = this.input.inputCourseLevelMission();
        String[] splitedInput = input.split(SEPARATOR);

        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(splitedInput[MISSION])
                && !backendResults[mission.getResultIndex()].getPairs().isEmpty()) {
                Result result = backendResults[mission.getResultIndex()];
                printer.printResult(result);
                return;
            }
        }
        throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE.getMessage());
    }

    private void renew() {
        backendResults = new Result[8];
        frontendResults = new Result[8];
        printer.printInfoMessage(InfoMessage.RENEW_COMPLETE_MESSAGE);
    }

    private void runBackEndMakePairLogic(String levelName, String missionName) {
        int resultIndex = 0;
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(missionName)) {
                resultIndex = mission.getResultIndex();
            }
        }

        if (backendResults[resultIndex] == null) {
            makeFrontendResult(missionName);
            return;
        }
        if (isRematchingYesOrNo()) {
            makeBackendResult(missionName);
            return;
        }
        makePair();
    }

    private void makeBackendResult(String missionName) {
        List<Pair> pairs = makeBackendPair();
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(missionName)) {
                Result result = new Result(mission, pairs);
                result.checkOneCrew();
                backendResults[mission.getResultIndex()] = result;
            }
        }
    }

    private void runFrontendMakePairLogic(String levelName, String missionName) {
        int resultIndex = 0;
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(missionName)) {
                resultIndex = mission.getResultIndex();
            }
        }

        if (frontendResults[resultIndex] == null) {
            makeFrontendResult(missionName);
            return;
        }
        if (isRematchingYesOrNo()) {
            makeFrontendResult(missionName);
            return;
        }
        makePair();
    }

    private void makeFrontendResult(String missionName) {
        List<Pair> pairs = makeFrontendPair();
        for (Mission mission : Mission.values()) {
            if (mission.getName().equals(missionName)) {
                Result result = new Result(mission, pairs);
                result.checkOneCrew();
                frontendResults[mission.getResultIndex()] = result;
            }
        }
    }

    private boolean isRematchingYesOrNo() {
        printer.printInfoMessage(InfoMessage.DO_REMATCHING_MESSAGE);
        String answer = input.inputRematching();

        return answer.equals(YES_SIGN);
    }


    private List<Pair> makeBackendPair() {
        Randoms.shuffle(backendCrews);
        AtomicInteger counter = new AtomicInteger();

        List<Pair> pairs = backendCrews.stream()
            .collect(Collectors.groupingBy(x -> counter.getAndIncrement() / PAIR_SIZE))
            .values()
            .stream()
            .map(Pair::new)
            .collect(Collectors.toList());

        return pairs;
    }

    private List<Pair> makeFrontendPair() {
        Randoms.shuffle(frontendCrews);
        AtomicInteger counter = new AtomicInteger();

        List<Pair> pairs = frontendCrews.stream()
            .collect(Collectors.groupingBy(x -> counter.getAndIncrement() / PAIR_SIZE))
            .values()
            .stream()
            .map(Pair::new)
            .collect(Collectors.toList());

        return pairs;
    }
}
