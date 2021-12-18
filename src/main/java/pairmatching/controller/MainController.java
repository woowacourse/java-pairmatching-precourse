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
