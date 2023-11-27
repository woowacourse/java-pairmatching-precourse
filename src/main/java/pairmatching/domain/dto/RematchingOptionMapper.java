package pairmatching.domain.dto;

import pairmatching.domain.entity.RematchingOption;

public class RematchingOptionMapper {
    public static RematchingOption toRematchingOption(String input) {
        return RematchingOption.findRematchingOption(input);
    }
}
