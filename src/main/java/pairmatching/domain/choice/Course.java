package pairmatching.domain.choice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<String> namesOfValues() {
        return Arrays.stream(values())
                .map(Course::getName)
                .collect(Collectors.toList());
    }
}
