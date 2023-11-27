package pairmatching.view;

import static pairmatching.messages.IOMessages.INPUT_FUNCTION;
import static pairmatching.messages.IOMessages.INPUT_REMATCHING;
import static pairmatching.messages.IOMessages.INPUT_SELECT_OPTIONS;
import static pairmatching.messages.IOMessages.SELECT_EXAMPLE;

import java.util.Arrays;
import pairmatching.domain.dto.CourseMissionMapper;
import pairmatching.domain.dto.FunctionMapper;
import pairmatching.domain.dto.RematchingOptionMapper;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.Function;
import pairmatching.domain.entity.RematchingOption;
import pairmatching.util.InputUtil;

public class InputView {

    public Function inputFunction() {
        System.out.println(INPUT_FUNCTION.getMessage());
        outputFunctions();

        String input = InputUtil.input();

        return FunctionMapper.toFunction(input);
    }

    public CourseMission inputCourseMission() {
        System.out.println(INPUT_SELECT_OPTIONS.getMessage());
        System.out.println(SELECT_EXAMPLE.getMessage());
        String input = InputUtil.input();

        return CourseMissionMapper.toCourseMission(input);
    }

    public RematchingOption inputRematchingOption() {
        System.out.println(INPUT_REMATCHING);
        System.out.println(RematchingOption.YES+" | "+RematchingOption.NO);
        String input = InputUtil.input();

        return RematchingOptionMapper.toRematchingOption(input);
    }

    private static void outputFunctions() {
        Arrays.stream(Function.values())
                .forEach(function
                        -> System.out.println(function.getOption() + ". " + function.getDescription()));
    }
}
