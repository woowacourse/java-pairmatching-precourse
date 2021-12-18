package pairmatching.controller;

import java.util.Scanner;

import pairmatching.controller.mainmenu.MenuValidator;
import pairmatching.controller.mainmenu.Option;
import pairmatching.domain.ErrorMessage;
import pairmatching.domain.crew.BackEndCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewReader;
import pairmatching.domain.mission.MissionController;
import pairmatching.view.UserView;

public class MainController {
    private UserView userView = new UserView();
    private MenuValidator menuValidator = new MenuValidator();
    private MissionController missionController = new MissionController();

    public void run() {
        initializeCrews();
        String optionSelected = requestMainMenuSelection();
        while (!optionSelected.equals(Option.QUIT.getOption())) {
            optionSelected = requestMainMenuSelection();
            runOptionSelected(optionSelected);
        }
    }

    private String requestMainMenuSelection() {
        try {
            userView.printMainMenu();
            for (Option option : Option.values()) {
                userView.printOption(option);
            }
            Scanner scn = new Scanner(System.in);
            String optionSelected = userView.readFromUser();
            menuValidator.checkExistingOption(optionSelected);
            return optionSelected;
        } catch (Exception exception) {
            userView.printError(exception);
            userView.printBlankLine();
            requestMainMenuSelection();
        }
        return null;
    }

    private void runOptionSelected(String optionSelected) {
        if (optionSelected.equals(Option.MATCHING.getOption())) {

        }
        if (optionSelected.equals(Option.INIT.getOption())) {

        }
        if (optionSelected.equals(Option.INQUIRY.getOption())) {

        }
    }

    private void initializeCrews() {
        initializeBackEndCrews();
        initializeFrontEndCrews();
        initializeMissionData();
    }

    private void initializeBackEndCrews() {
        CrewReader reader = new CrewReader();
        for (Crew crew : reader.readBECrewFromMd()) {
            BackEndCrewRepository.addCrew(crew);
        }
    }

    private void initializeFrontEndCrews() {
        CrewReader reader = new CrewReader();
        for (Crew crew : reader.readFECrewFromMd()) {
            BackEndCrewRepository.addCrew(crew);
        }
    }

    private void initializeMissionData() {
        missionController.initializeMissions();
    }

    private void checkUserInput(String input) {
        if(input == null) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                "잘못된 입력입니다 다시 입력해주세요."));
        }
    }
}
