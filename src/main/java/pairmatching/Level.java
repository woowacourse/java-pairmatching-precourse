package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1", new String[] {"자동차경주", "로또", "숫자야구게임"}),
    LEVEL2("레벨2", new String[] {"장바구니", "결제", "지하철 노선도"}),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", new String[] {"성능개선","배포"}),
    LEVEL5("레벨5");
    private String name;
    private ArrayList<String> mission = new ArrayList<>();

    Level(String name) {
        this.name = name;
    }

    Level(String name, String[] mission) {
        this.name = name;
        this.mission.addAll(Arrays.asList(mission));
    }

    public static Boolean JudgeLevel(String inputLevel, String mission) {
        for (Level level : Level.values()) {
            if (level.name.equals(inputLevel) && level.mission.contains(mission)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean JudgeLevel(String inputLevel) {
        for (Level level : Level.values()) {
            if (level.name.equals(inputLevel)) {
                return true;
            }
        }
        return false;
    }
}