package pairmatching.domain;

import java.util.HashMap;
import java.util.List;

public class ProgramInfo {
    Course course;
    Level level;
    Mission mission;
    HashMap<Crew, Crew> pairs = new HashMap<>(); // 크루1 -> 크루2/ 크루2 -> 크루1 이런 식으로

    public ProgramInfo(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    //페어들을 넣다가 있어야 함.
    //같은 기준은 course, level, mission?

    public boolean isMatch(Crew crew1, Crew crew2) {
        return pairs.get(crew1).equals(crew2);
    }

    public void savePairs(List<Crew> shuffledCrews) {
        // shuffledCrews하나씩 꺼내서
        // hashMap에 넣어준다.
    }
}
