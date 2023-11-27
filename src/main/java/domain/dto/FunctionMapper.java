package domain.dto;

import domain.entity.Function;
import util.StringUtil;

public class FunctionMapper {
    public static Function toFunction(String input) {
        final String deleteSpaces = StringUtil.removeAllSpaces(input);

        return Function.findFunction(deleteSpaces);
    }
}
