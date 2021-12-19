package pairmatching.controller;

import java.util.Scanner;

import pairmatching.controller.mainmenu.MenuValidator;
import pairmatching.controller.mainmenu.Option;
import pairmatching.domain.crew.BackEndCrewRepository;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewReader;
import pairmatching.view.UserView;

public class MainController {
    private UserView userView = new UserView();
    private MenuValidator menuValidator = new MenuValidator();

    public void run() {
        initializeCrews();
        String OptionSelected = requestMainMenuSelection();
        while (!OptionSelected.equals(Option.end.getOption())) {
            OptionSelected = requestMainMenuSelection();
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

<<<<<<< HEAD
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


=======
>>>>>>> parent of 77a8c73 (feat: 초기 미션 생성 기능 구현)
    private void initializeCrews() {
        initializeBackEndCrews();
        initializeFrontEndCrews();
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
}
