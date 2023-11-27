package view;

import static messages.IOMessages.INPUT_FUNCTION;
import static messages.IOMessages.INPUT_SELECT_OPTIONS;

import domain.dto.CourseMissionMapper;
import domain.dto.FunctionMapper;
import domain.entity.CourseMission;
import domain.entity.Function;
import util.InputUtil;

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
