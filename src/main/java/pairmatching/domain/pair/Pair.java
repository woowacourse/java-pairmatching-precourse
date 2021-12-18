package pairmatching.domain.pair;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> crewSet;

    public Pair(String crew1, String crew2, Course course) {
        crewSet = new ArrayList<>();
        makeSet(Crew.of(crew1, course), Crew.of(crew2, course));
    }

    public Pair(String crew1, String crew2, String crew3, Course course) {
        crewSet = new ArrayList<>();
        makeSet(Crew.of(crew1, course), Crew.of(crew2, course), Crew.of(crew3, course));
    }
    public static Pair of(String crew1, String crew2, Course course) {
        return new Pair(crew1, crew2, course);
    }

    public static Pair of(String crew1, String crew2, String crew3, Course course) {
        return new Pair(crew1, crew2, crew3, course);
    }

    private void makeSet(Crew crew1, Crew crew2) {
        crewSet.add(crew1);
        crewSet.add(crew2);
    }

    private void makeSet(Crew crew1, Crew crew2, Crew crew3) {
        crewSet.add(crew1);
        crewSet.add(crew2);
        crewSet.add(crew3);
    }

    public boolean hasCrewName(String targetName) {
        return crewSet.stream().anyMatch((crew) -> crew.isName(targetName));
    }

    public boolean hasCrewNames(String name1, String name2) {
        return hasCrewName(name1) && hasCrewName(name2);
    }

    @Override
    public boolean equals(Object targetObj) {
        Pair target = (Pair) targetObj;
        return target.hasCrew(crewSet.get(0)) && target.hasCrew(crewSet.get(1));
    }

    private boolean hasCrew(Crew targetCrew) {
        return crewSet.contains(targetCrew);
    }
}
