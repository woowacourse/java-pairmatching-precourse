package pairmatching;

public class PairKey {
    private final String courseName;
    private final int level;
    private final String mission;

    public PairKey(String courseName, String mission, int level) {
        this.courseName = courseName;
        this.mission = mission;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairKey)) return false;
        PairKey key = (PairKey) o;
        return courseName.equals(key.courseName) && level == key.level && mission.equals(key.mission);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
