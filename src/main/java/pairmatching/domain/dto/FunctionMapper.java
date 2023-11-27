package pairmatching.domain.dto;

import pairmatching.domain.entity.Function;
import pairmatching.util.StringUtil;

public class FunctionMapper {
    private FunctionMapper() {

    }

    public static Function toFunction(String input) {
        final String deleteSpaces = StringUtil.removeAllSpaces(input);

        return Function.findFunction(deleteSpaces);
    }
}
