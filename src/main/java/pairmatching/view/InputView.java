package pairmatching.view;

import static pairmatching.messages.IOMessages.INPUT_FUNCTION;
import static pairmatching.messages.IOMessages.INPUT_SELECT_OPTIONS;

import pairmatching.domain.dto.CourseMissionMapper;
import pairmatching.domain.dto.FunctionMapper;
import pairmatching.domain.entity.CourseMission;
import pairmatching.domain.entity.Function;
import pairmatching.util.InputUtil;

public class InputView {

    public Function inputFunction() {
        System.out.println(INPUT_FUNCTION.getMessage());
        String input = InputUtil.input();

        return FunctionMapper.toFunction(input);
    }

    public CourseMission inputCourseMission() {
        System.out.println(INPUT_SELECT_OPTIONS.getMessage());
        String input = InputUtil.input();

        return CourseMissionMapper.toCourseMission(input);
    }
}
