package pairmatching.domain.entity;

import java.util.Arrays;
import pairmatching.util.ExceptionUtil;

public enum Function {
    PAIR_MATCHING("1","페어 매칭"),
    PAIR_CHECK("2","페어 조회"),
    PAIR_RESET("3","페어 초기화"),
    QUIT("Q","종료");

    private final String option;
    private final String description;

    Function(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public static Function findFunction(String option) {
        return Arrays.stream(Function.values())
                .filter(function -> function.option.equals(option))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }
}
