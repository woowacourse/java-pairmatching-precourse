package validation;

import java.util.List;

public class CheckOption {
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    
    public static void checkValidOption(List<String> options, String option) {
        if(!options.stream().anyMatch(o -> o.equals(option))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
