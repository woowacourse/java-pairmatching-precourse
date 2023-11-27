package pairmatching.controller;

import static pairmatching.domain.entity.Function.PAIR_CHECK;
import static pairmatching.domain.entity.Function.PAIR_MATCHING;
import static pairmatching.domain.entity.Function.PAIR_RESET;
import static pairmatching.domain.entity.Function.QUIT;
import static pairmatching.domain.entity.RematchingOption.YES;
import static pairmatching.messages.ErrorMessages.INVALID_COURSE_MISSION;
import static pairmatching.messages.ErrorMessages.INVALID_FUNCTION;
import static pairmatching.messages.ErrorMessages.INVALID_REMATCHING_SELECT;
import static pairmatching.messages.ErrorMessages.NOT_EXIST_MATCHING_RESULT;

import java.util.Optional;
import pairmatching.domain.dto.MatchingResultMapper;
import pairmatching.domain.entity.Course;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.Function;
import pairmatching.domain.entity.MatchingResult;
import pairmatching.domain.entity.RematchingOption;
import pairmatching.service.MatchingService;
import pairmatching.util.InputUtil;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MatchingService matchingService;

    public MatchingController(InputView inputView, OutputView outputView, MatchingService matchingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.matchingService = matchingService;
    }

    public void play() {

        while (true) {
            final Function function = inputValidFunction();

            if (function.equals(QUIT)) {
                return;
            }
            
            processFunctionInput(function);
        }
    }

    private void processFunctionInput(Function function) {
        processPairMatching(function);

        processPairCheck(function);

        processPairReset(function);
    }

    private void processPairReset(Function function) {
        if (function.equals(PAIR_RESET)) {
            matchingService.resetMatching();
        }
    }

    private void processPairCheck(Function function) {
        if (function.equals(PAIR_CHECK)) {
            outputView.outputCourseMission();
            final CourseMission courseMission = inputValidCourseMission();

            Optional<MatchingResult> matchingResult = matchingService.findMatchingResult(courseMission);

            if (!matchingResult.isPresent()) {
                outputView.outputErrorMessage(NOT_EXIST_MATCHING_RESULT.getMessage());
            }
            else {
                outputView.outputPairMatchingResult(MatchingResultMapper.from(matchingResult.get()));
            }
        }
    }

    private void processPairMatching(Function function) {
        if (function.equals(PAIR_MATCHING)) {
            outputView.outputCourseMission();
            final CourseMission courseMission = inputValidCourseMission();
            Course course = courseMission.getCourse();

            Optional<MatchingResult> foundMatchingResult = matchingService.findMatchingResult(courseMission);
            if (!foundMatchingResult.isPresent()) {
                RematchingOption rematchingOption = inputValidRematchingOption();
                if (rematchingOption.equals(YES)) {
                    MatchingResult matchingResult = matchingService.createMatchingResult(course.getCrews());
                    outputView.outputPairMatchingResult(MatchingResultMapper.from(matchingResult));
                    matchingService.save(courseMission, matchingResult);
                }
            }

            else {
                MatchingResult matchingResult = matchingService.createMatchingResult(course.getCrews());
                outputView.outputPairMatchingResult(MatchingResultMapper.from(matchingResult));
                matchingService.save(courseMission, matchingResult);
            }
        }
    }

    private RematchingOption inputValidRematchingOption() {
        return InputUtil.retryOnInvalidInput(this::inputRematchingOption,
                errorMessage -> outputView.outputErrorMessage(INVALID_REMATCHING_SELECT.getMessage()));
    }

    private RematchingOption inputRematchingOption() {
        return inputView.inputRematchingOption();
    }

    private CourseMission inputValidCourseMission() {
        return InputUtil.retryOnInvalidInput(this::inputCourseMission,
                errorMessage -> outputView.outputErrorMessage(INVALID_COURSE_MISSION.getMessage()));
    }

    private CourseMission inputCourseMission() {
        return inputView.inputCourseMission();
    }

    private Function inputValidFunction() {
        return InputUtil.retryOnInvalidInput(this::inputFunction,
                errorMessage -> outputView.outputErrorMessage(INVALID_FUNCTION.getMessage()));
    }

    private Function inputFunction() {
        return inputView.inputFunction();
    }


}
