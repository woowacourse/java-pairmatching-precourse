package pairmatching.domain.pair;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;

import java.util.HashSet;
import java.util.Set;

public class Pair {
    private final Set<Crew> crewSet;

    public Pair(String crew1, String crew2, Course course) {
        crewSet = new HashSet<>();
        makeSet(Crew.of(crew1, course), Crew.of(crew2, course));
    }

    public Pair(String crew1, String crew2, String crew3, Course course) {
        crewSet = new HashSet<>();
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
}
