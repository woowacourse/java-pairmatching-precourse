package pairmatching.model.crew;

public class CrewName {
    private String crewName;

    public CrewName(final String crewName) {
        this.crewName = crewName;
    }

    public boolean isSame(String name){
        return this.crewName.equals(name);
    }

}
