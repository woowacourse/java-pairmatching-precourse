package pairmatching;

import pairmatching.missionName.MissionName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mission {

    private Course course;

    private MissionName missionName;

    private List<Pair> pairList = new ArrayList<>();

    public Mission (Course course, MissionName missionName) {
        this.course = course;
        this.missionName = missionName;
    }

    public Course getCourse() {
        return course;
    }

    public MissionName getMissionName() {
        return missionName;
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    public boolean isMatched() {
        return pairList.size() != 0;
    }
}
