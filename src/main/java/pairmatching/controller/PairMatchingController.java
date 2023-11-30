package pairmatching.controller;

import static pairmatching.validator.InputChoiceValidator.*;
import static pairmatching.view.OutputView.*;

import pairmatching.service.PeopleService;
import pairmatching.validator.InputChoiceValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final PeopleService peopleService;

    public PairMatchingController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public void run() {
        InputPeople();
        while (true) {
            String choice = InputChoice();
            if (choice.equals("Q")) {
                break;
            }
            if(choice.equals("1")){
                pairMatching();
            }
        }
    }

    private void InputPeople() {
        peopleService.initPeople();
    }

    private String InputChoice() {
        while (true) {
            try {
                return validateInputChoice(InputView.chooseFunction());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private String pairMatching(){
        while(true){
            try{
                return InputView.chooseCourse();
            }catch(IllegalArgumentException e){
                printErrorMessage(e.getMessage());
            }
        }
    }
}
