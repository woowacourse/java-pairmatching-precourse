package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProgramInfo {
    Course course;
    Level level;
    Mission mission;
    LinkedHashMap<Crew, Crew> pairs = new LinkedHashMap<>(); // 크루1 -> 크루2/ 크루2 -> 크루1 이런 식으로

    public ProgramInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        pairs.clear();
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public boolean isMatch(Crew crew1, Crew crew2) {
        boolean result = false;
        if (pairs.containsKey(crew1)) {
            result = pairs.get(crew1).equals(crew2);
        }
        if (pairs.containsKey(crew2)) {
            result = result || pairs.get(crew2).equals(crew1);
        }

        return result;
    }

    public void savePairs(List<Crew> shuffledCrews) {
        int crewsCnt = shuffledCrews.size();
        for (int i = 0; i < crewsCnt / 2; i++) {
            pairs.put(shuffledCrews.get(i*2), shuffledCrews.get(i*2 + 1));
        }
        if (crewsCnt % 2 == 1) {
            pairs.put(shuffledCrews.get(crewsCnt - 2), shuffledCrews.get(crewsCnt - 1));
            pairs.put(shuffledCrews.get(crewsCnt - 1), shuffledCrews.get(crewsCnt - 3));
        }
    }

    public void clearPairs() {
        pairs.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProgramInfo that = (ProgramInfo)o;
        return getCourse() == that.getCourse() && getLevel() == that.getLevel() && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getLevel(), mission);
    }

    public LinkedHashMap<Crew, Crew> getPairs() {
        //한쌍으로 만들어서 보내줘야함.
        return pairs;
    }
}
