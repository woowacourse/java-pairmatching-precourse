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

    private void printMisionsAvailable() {
        userView.printMessage("#############################################");
        userView.printMessage("과정: 백엔드 | 프론트엔드");
        userView.printMessage("미션:");
        userView.printMessage("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        userView.printMessage("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        userView.printMessage("  - 레벨3: ");
        userView.printMessage("  - 레벨4: 성능개선 | 배포");
        userView.printMessage("  - 레벨5: \n");
        userView.printMessage("#############################################");
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
