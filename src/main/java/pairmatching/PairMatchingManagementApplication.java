package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;
import pairmatching.utils.FileUtility;
import pairmatching.view.InputSystem;

public class PairMatchingManagementApplication {

    private final static List<String> readToListFromREADME = Arrays.asList("backend-crew.md", "frontend-crew.md");
    private final static int BECK_END = 0;
    private final static int FRONT_END = 1;
    private final static char PAIR_MATCHING = 1;
    private final static char PAIR_SELECT = 2;
    private final static char PAIR_RESET = 3;
    private final static char EXIT = 'Q';

    private final FileUtility fileReadUtility;
    private final InputSystem inputSystem;

    private List<Crew> backendCrews;
    private List<Crew> frontedCrews;

    public PairMatchingManagementApplication() {
        fileReadUtility = FileUtility.getInstance();
        inputSystem = InputSystem.getInstance();
    }

    public void init() {
        readCrewsFromFile();
    }

    public void start() {
        init();
        char inputFunctionNumber = inputSystem.inputFunctionList();
        if (inputFunctionNumber == PAIR_MATCHING) {

        } else if (inputFunctionNumber == PAIR_SELECT) {

        } else if (inputFunctionNumber == PAIR_RESET) {

        } else if (inputFunctionNumber == EXIT) {

        }
    }

    public void readCrewsFromFile() {
        backendCrews = new ArrayList<>();
        frontedCrews = new ArrayList<>();
        for (int group = 0; group < readToListFromREADME.size(); group++) {
            if (group == BECK_END) {
                backendCrews = fileReadUtility.readToListFromREADME(readToListFromREADME.get(group)).stream().map(Crew::new).collect(Collectors.toList());
            } else if (group == FRONT_END) {
                frontedCrews = fileReadUtility.readToListFromREADME(readToListFromREADME.get(group)).stream().map(Crew::new).collect(Collectors.toList());
            }
        }
    }


}
