package pairmatching;

import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.System.SystemErrorMessage;
import pairmatching.domain.Crew;
import pairmatching.view.InputSystem;
import pairmatching.view.OutputSystem;

public class PairMatchingManagementApplication {

    private final static String BACK_END = "백엔드";
    private final static String FRONT_END = "프론트앤드";
    private final static char PAIR_MATCHING = 1;
    private final static char PAIR_SELECT = 2;
    private final static char PAIR_RESET = 3;
    private final static char EXIT = 'Q';

    private final InputSystem inputSystem;
    private final ConstantDataStore constantDataStore;
    private final OutputSystem outputSystem;

    private StringBuilder matchingResults;
    boolean MatchingAttempts = false;

    public PairMatchingManagementApplication() {
        inputSystem = InputSystem.getInstance();
        constantDataStore = ConstantDataStore.getInstance();
        outputSystem = OutputSystem.getInstance();
    }

    public void start() {
        char inputFunctionNumber;
        do {
            inputFunctionNumber = inputSystem.inputFunctionList();
            if (inputFunctionNumber == PAIR_SELECT && !MatchingAttempts) {
                outputSystem.printConsoleMessage(SystemErrorMessage.NOT_MATCHING_HISTORY.getMessage());
                continue;
            }
            String courseAndLevelAndMission = inputSystem.inputPropertyInput();
            Property property = extractedPropertyInformation(courseAndLevelAndMission);
            if (!MatchingAttempts) {
                behaveFunction(inputFunctionNumber, property);
            } else {
                String inputYesOrNo = inputSystem.inputYesOrNo();
            }

        } while (inputFunctionNumber != EXIT);
    }

    private Property extractedPropertyInformation(String courseAndLevelAndMission) {
        String[] propertyInformation = courseAndLevelAndMission.split(",");
        List<String> courseLevelMission = new ArrayList<>();

        for (int index = 0; index < propertyInformation.length; index++) {
            propertyInformation[index] = propertyInformation[index].trim();
        }
        String course = propertyInformation[0];
        String level = propertyInformation[1];
        String mission = propertyInformation[2];

        return new Property(course, level, mission);
    }

    private void behaveFunction(char inputFunctionNumber, Property property) {
        List<Crew> crews = pickCrews(property);
        boolean even = (crews.size() % 2 == 0);
        if (inputFunctionNumber == PAIR_MATCHING) {
        } else if (inputFunctionNumber == PAIR_SELECT) {

        } else if (inputFunctionNumber == PAIR_RESET) {

        } else if (inputFunctionNumber == EXIT) {

        }
    }


    private List<Crew> pickCrews(Property property) {
        if (property.course.equals(BACK_END)) {
            return constantDataStore.getBackendCrews();
        } else if (property.course.equals(FRONT_END)) {
            return constantDataStore.getFrontedCrews();
        }
        return null;
    }

    class Property {
        private final String course;
        private final String level;
        private final String mission;

        public Property(String course, String level, String mission) {
            this.course = course;
            this.level = level;
            this.mission = mission;
        }

        public String getCourse() {
            return course;
        }

        public String getLevel() {
            return level;
        }

        public String getMission() {
            return mission;
        }
    }

}
