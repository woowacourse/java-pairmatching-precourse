package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Missions {

    private final List<Mission> missions;

    public Missions(List<Mission> missions) {
        this.missions = missions;
    }

    public static Missions init() {
        return new Missions(new ArrayList<>());
    }
}
