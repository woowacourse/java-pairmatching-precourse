package pairmatching.model.information;

public class CourseName {
    private final String courseName;

    public CourseName(final String courseName) {
        this.courseName = courseName;
    }

    public boolean isSame(String name){
        return this.courseName.equals(name);
    }

}
