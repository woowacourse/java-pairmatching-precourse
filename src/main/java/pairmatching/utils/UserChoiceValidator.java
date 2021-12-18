package pairmatching.utils;

import static pairmatching.constants.ExceptionMessages.*;
import static pairmatching.constants.SystemConstants.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserChoiceValidator {

    public static void validateMainMenuActionInput(String input) {
        List<String> validateInputs = Stream.of(ONE, TWO, THREE, EXIT_Q)
                .collect(Collectors.toList());
        if (!validateInputs.contains(input)) {
            throw new IllegalArgumentException(INVALID_CHOICE_EXCEPTION);
        }
    }
}
