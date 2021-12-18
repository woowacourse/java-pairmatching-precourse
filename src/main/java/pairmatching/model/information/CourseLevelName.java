package pairmatching.model.information;

public class CourseLevelName {
    private String courseLevelName;

    public CourseLevelName(final String courseLevelName) {
        this.courseLevelName = courseLevelName;
    }

    public boolean isSame(final String courseLevelName){
        return this.courseLevelName.equals(courseLevelName);
    }
}
