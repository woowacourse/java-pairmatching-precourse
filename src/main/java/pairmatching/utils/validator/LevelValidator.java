package pairmatching.utils.validator;

import static pairmatching.utils.Error.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Level;

public class LevelValidator {

    public static void validate(String level) {
        List<String> levelList = Arrays.stream(Level.values())
            .map(Level::getName)
            .collect(Collectors.toList());
        if (!levelList.contains(level)) {
            throw new IllegalArgumentException(LEVEL_NOT_EXIST);
        }
    }
}
