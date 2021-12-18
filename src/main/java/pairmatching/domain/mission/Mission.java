package pairmatching.domain.mission;

import pairmatching.domain.Level;
import pairmatching.domain.course.Course;
import pairmatching.domain.pair.Pair;
import pairmatching.util.pairProvider.PairProvider;

import java.util.List;
import java.util.Set;

public class Mission {
    private final Course course;
    private final Level level;
    private final MissionName name;
    private Set<Pair> pairSet;

    public Mission(Course course, Level level, MissionName name, List<String> nameList) {
        this.course = course;
        this.level = level;
        this.name = name;

        makePairSet(nameList);
    }

    public static Mission of(Course course, Level level, MissionName name, List<String> nameList) {
        return new Mission(course, level, name, nameList);
    }

    public boolean isName(String comparison) {
        return name.isSame(comparison);
    }

    public void makePairSet(List<String> nameList) {
        pairSet = PairProvider.getPairsRandomly(nameList, course);
    }

    public boolean existsPairByNames(String name1, String name2) {
        return pairSet.stream().anyMatch((pair) -> pair.hasCrewNames(name1, name2));
    }

    public boolean isSameMission(Level level, MissionName missionName) {
        return isSameLevel(level) && isSameName(missionName);
    }

    private boolean isSameName(MissionName missionName) {
        return name.equals(missionName);
    }

    private boolean isSameLevel(Level level) {
        return this.level.equals(level);
    }

    public boolean hasSamePair(Mission target) {
        if(target.isSameLevel(level)) {
            return pairSet.stream().anyMatch((pair) -> target.hasPair(pair));
        }
        return false;
    }

    private boolean hasPair(Pair target) {
        return pairSet.stream().anyMatch((pair) -> pair.equals(target));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        pairSet.stream().forEach((pair) -> {
            sb.append(pair.toString());
            sb.append('\n');
        });

        return sb.toString();
    }
}
