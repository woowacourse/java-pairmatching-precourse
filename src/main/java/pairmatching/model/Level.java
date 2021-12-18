package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.util.Message;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Arrays.asList("")),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Arrays.asList(""));

    private String name;
    private List<String> missions;

    Level(String name, List<String> mission) {
        this.name = name;
        this.missions = mission;
    }

    public String getName() {
        return name;
    }

    public List<String> getMissions() {
        return missions;
    }

    public static String parseMission(Level level, String input) {
        return level.getMissions().stream()
            .filter(mission -> mission.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Message.MISSION_ERROR));
    }

    public static Level parseLevel(String input) {
        return Arrays.stream(values())
            .filter(menu -> menu.name.equals(input))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(Message.LEVEL_ERROR));
    }
}