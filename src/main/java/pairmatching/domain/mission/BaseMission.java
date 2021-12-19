package pairmatching.domain.mission;

import pairmatching.domain.level.Level;

public enum BaseMission {
    자동차경주(Level.LEVEL1, "자동경주"),
    로또(Level.LEVEL1, "로또"),
    숫자야구게임(Level.LEVEL1, "숫자야구게임"),

    장바구니(Level.LEVEL2, "장바구니"),
    결제(Level.LEVEL2, "결제"),
    지하철노선도(Level.LEVEL2, "지하철노선도"),

    성능개선(Level.LEVEL4, "성능개선"),
    배포(Level.LEVEL4, "배포");

    private Mission mission;

    BaseMission(Level level, String name) {
        mission = new Mission(level,name);
    }

    public Mission getMission() {
        return mission;
    }

    public String getLevelName(){
        return mission.getLevel().getName();
    }


}
