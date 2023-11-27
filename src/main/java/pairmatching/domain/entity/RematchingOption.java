package pairmatching.domain.entity;

import java.util.Arrays;
import pairmatching.util.ExceptionUtil;

public enum RematchingOption {
    YES("네"),
    NO("아니오");

    private final String description;

    RematchingOption(String description) {
        this.description = description;
    }

    public static RematchingOption findRematchingOption(String input) {
        return Arrays.stream(values())
                .filter(rematchingOption -> rematchingOption.description.equals(input))
                .findAny()
                .orElseThrow(() -> ExceptionUtil.returnInvalidValueException());
    }

    public String getDescription() {
        return description;
    }
}
