package pairmatching;

import pairmatching.view.InputSystem;

public class PairMatchingManagementApplication {

    private final static char PAIR_MATCHING = 1;
    private final static char PAIR_SELECT = 2;
    private final static char PAIR_RESET = 3;
    private final static char EXIT = 'Q';

    private final InputSystem inputSystem;
    private final ConstantDataStore constantDataStore;

    public PairMatchingManagementApplication() {
        inputSystem = InputSystem.getInstance();
        constantDataStore = ConstantDataStore.getInstance();
    }

    public void start() {
//        char inputFunctionNumber = inputSystem.inputFunctionList();
//        behaveFunction(inputFunctionNumber);
        String courseAndLevelAndMission = inputSystem.inputPropertyInput();
    }

    private void behaveFunction(char inputFunctionNumber) {
        if (inputFunctionNumber == PAIR_MATCHING) {

        } else if (inputFunctionNumber == PAIR_SELECT) {

        } else if (inputFunctionNumber == PAIR_RESET) {

        } else if (inputFunctionNumber == EXIT) {

        }
    }

}
