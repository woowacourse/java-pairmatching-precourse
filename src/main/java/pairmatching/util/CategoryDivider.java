package pairmatching.util;

import pairmatching.view.Constant;

import java.util.Arrays;
import java.util.List;

public class CategoryDivider {
    public static List<String> divideCategory(String s) {
        List<String> answer = Arrays.asList(s.split(Constant.INPUT_DELIMITER));
        return answer;
    }
}
