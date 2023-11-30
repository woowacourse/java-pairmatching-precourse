package pairmatching.controller;

import static pairmatching.validator.InputChoiceValidator.*;
import static pairmatching.validator.InputCourseValidator.*;
import static pairmatching.view.OutputView.*;

import pairmatching.domain.Course;
import pairmatching.service.PeopleService;
import pairmatching.view.InputView;

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
                peopleService.pairMatching(InputCourse());
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

    private Course InputCourse(){
        while(true){
            try{
                return validateInputCourse(InputView.chooseCourse());
            }catch(IllegalArgumentException e){
                printErrorMessage(e.getMessage());
            }
        }
    }
}
