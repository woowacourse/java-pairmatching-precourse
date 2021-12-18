package pairmatching.model.information;

public class CourseLevelName {
    private final String levelName;

    public CourseLevelName(final String levelName) {
        this.levelName = levelName;
    }

    public boolean isSame(String levelName) {
        return this.levelName.equals(levelName);
    }

}
