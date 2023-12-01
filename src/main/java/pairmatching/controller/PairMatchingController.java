package pairmatching.controller;

import static pairmatching.validator.InputChoiceValidator.validateInputChoice;
import static pairmatching.validator.InputCourseValidator.validateInputCourse;
import static pairmatching.view.OutputView.printErrorMessage;

import pairmatching.domain.Course;
import pairmatching.service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final MatchingService matchingService;
    private int retryCount = 0;

    public PairMatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void run() {
        InputPeople();
        while (true) {
            String choice = InputChoice();
            if (choice.equals("Q")) {
                break;
            }
            if (choice.equals("1")) {
                pairMatching();
            }
        }
    }

    private void pairMatching() {
        Course course = InputCourse();
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);

        try {
            if (!matchingHistoryByCourse) {
                matchingService.pairMatching(course);
                showPairMatchingResult(course);
            } else {
                processRetryCourse(matchingService, course);
            }
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void processRetryCourse(MatchingService matchingService, Course course) {
        try {
            if (InputView.inputRetryCourse().equals("예")) {
                matchingService.updatePairMatching(course);
                showPairMatchingResult(course);
            }
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void showPairMatchingResult(Course course) {
        OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
    }

    private void InputPeople() {
        matchingService.initPeople();
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

    private Course InputCourse() {
        while (true) {
            try {
                return validateInputCourse(InputView.chooseCourse());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }
}
