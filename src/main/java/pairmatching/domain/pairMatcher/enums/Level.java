package pairmatching.domain.pairMatcher.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1", new ArrayList<String>(Arrays.asList("자동차경주","로또","숫자야구게임"))),
    LEVEL2("레벨2", new ArrayList<String>(Arrays.asList("장바구니","결제","지하철노선도"))),
    LEVEL3("레벨3", new ArrayList<String>()),
    LEVEL4("레벨4", new ArrayList<String>(Arrays.asList("성능개선","배포"))),
    LEVEL5("레벨5", new ArrayList<String>());

    private String name;
    private ArrayList<String> missions;

    Level(String name, ArrayList<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMissions() {
        return missions;
    }

    public boolean isExistMission(String missionName) {
        for (String mission : missions) {
            if (mission.equals(missionName)){
                return true;
            }
        }
        return false;
    }
}
