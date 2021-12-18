package pairmatching.model.information;

public class CourseMission {

    private final String missionName;

    public CourseMission(final String missionName) {
        this.missionName = missionName;
    }

    public boolean isSame(String name){
        return this.missionName.equals(name);
    }

}
