package pairmatching.domain;

import java.util.List;

public class Pair {

    private List<String> names;
    private String course;
    private String level;
    private String mission;

    public Pair(List<String> names, String value) {
        this.names = names;
        String[] values = value.split(", ");
        this.course = values[0];
        this.level = values[1];
        this.mission = values[2];
    }

    public List<String> getNames() {
        return names;
    }

    public boolean check(String value) {
        String[] values = value.split(", ");
        if (course.equals(values[0]) && level.equals(values[1]) && mission.equals(values[2])) {
            return true;
        }
        return false;
    }
}
