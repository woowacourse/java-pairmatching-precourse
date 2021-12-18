package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.validation.Text;

public class Mission {
    private Level level;
    private String name;
    List<String> backendPair;
    List<String> frontendPair;

    public Mission(Level level, String name) {
        this.level = level;
        this.name = name;
        backendPair = new ArrayList<>();
        frontendPair = new ArrayList<>();
    }

    public String getLevelString() {
        return level.toString();
    }

    public String getName() {
        return name;
    }

    public void addCrewName(String course, List<String> pair) {
        if (course.equals(Text.BACKEND)) {
            backendPair = pair;
            return;
        }

        if (course.equals(Text.FRONTEND)) {
            frontendPair = pair;
            return;
        }
    }

    public List<String> getPair(String course) {
        if (course.equals(Text.BACKEND) && !backendPair.isEmpty()) {
            return backendPair;
        }

        if (course.equals(Text.FRONTEND) && !backendPair.isEmpty()) {
            return frontendPair;
        }

        return null;
    }
}
