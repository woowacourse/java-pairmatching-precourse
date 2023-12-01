package pairmatching.controller;

import static pairmatching.constants.ErrorMessage.NO_MATCHING_ERROR;
import static pairmatching.constants.ProgressConstants.NO_RETRY;
import static pairmatching.constants.ProgressConstants.PAIR_MATCHING;
import static pairmatching.constants.ProgressConstants.PAIR_RESET;
import static pairmatching.constants.ProgressConstants.PAIR_SEARCH;
import static pairmatching.constants.ProgressConstants.QUIT;
import static pairmatching.constants.ProgressConstants.RETRY;
import static pairmatching.validator.InputChoiceValidator.validateInputChoice;
import static pairmatching.validator.InputCourseValidator.validateInputCourse;
import static pairmatching.validator.InputRetryValidator.validateInputRetry;
import static pairmatching.view.InputView.chooseCourse;
import static pairmatching.view.InputView.chooseFunction;
import static pairmatching.view.InputView.inputRetryCourse;
import static pairmatching.view.OutputView.printErrorMessage;

import pairmatching.domain.Course;
import pairmatching.service.MatchingService;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final MatchingService matchingService;

    public PairMatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public void run() {
        InputPeople();
        while (true) {
            String choice = InputChoice();
            if (choice.equals(QUIT.getConstName())) {
                break;
            }
            if (choice.equals(PAIR_MATCHING.getConstName())) {
                pairMatching();
            }
            if (choice.equals(PAIR_SEARCH.getConstName())) {
                showMatchingHistory();
            }
            if (choice.equals(PAIR_RESET.getConstName())) {
                clearMatchingHistory();
            }
        }
    }

    private void InputPeople() {
        matchingService.initPeople();
    }

    private String InputChoice() {
        while (true) {
            try {
                return validateInputChoice(chooseFunction());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private Course InputCourse() {
        while (true) {
            try {
                return validateInputCourse(chooseCourse());
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
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
        while (true) {
            try {
                String inputRetry = validateInputRetry(inputRetryCourse());
                if (inputRetry.equals(RETRY.getConstName())) {
                    matchingService.updatePairMatching(course);
                    showPairMatchingResult(course);
                    break;
                }
                if (inputRetry.equals(NO_RETRY.getConstName())) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private void showPairMatchingResult(Course course) {
        OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
    }

    private void showMatchingHistory() {
        Course course = InputCourse();
        boolean matchingHistoryByCourse = matchingService.findMatchingHistoryByCourse(course);

        try {
            if (matchingHistoryByCourse) {
                OutputView.printMatchingResult(matchingService.pairMatchingResult(course));
            } else {
                throw new IllegalArgumentException(NO_MATCHING_ERROR.getMessage());
            }
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void clearMatchingHistory() {
        matchingService.clearMatchingHistory();
    }
}
