package pairmatching;

public class PairKey {
    private final String courseName;
    private final int level;

    public PairKey(String courseName, int level) {
        this.courseName = courseName;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PairKey)) return false;
        PairKey key = (PairKey) o;
        return courseName == key.courseName && level == key.level;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
