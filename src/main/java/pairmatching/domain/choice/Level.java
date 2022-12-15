package pairmatching.domain.choice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> namesOfValues() {
        return Arrays.stream(values())
                .map(Level::getName)
                .collect(Collectors.toList());
    }
}
