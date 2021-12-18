package pairmatching.model.information;

public class CourseMissionName {

    private final String missionName;

    public CourseMissionName(final String missionName) {
        this.missionName = missionName;
    }

    public boolean isSame(String name){
        return this.missionName.equals(name);
    }

}
