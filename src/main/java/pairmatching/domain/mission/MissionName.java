package pairmatching.domain.mission;

public enum MissionName {
    RACING_CAR("자동차경주");

    private String name;

    MissionName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(String comparison) {
        return name.equals(comparison);
    }
}
