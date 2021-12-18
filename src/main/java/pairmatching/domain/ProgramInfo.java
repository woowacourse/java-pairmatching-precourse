package pairmatching.domain;

import java.util.ArrayList;
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

    public boolean isMatch(Crew crew1, Crew crew2) {
        return pairs.get(crew1).equals(crew2) || pairs.get(crew2).equals(crew1);
    }

    public void savePairs(List<Crew> shuffledCrews) {
        int crewsCnt = shuffledCrews.size();
        for (int i = 0; i < crewsCnt / 2; i++) {
            pairs.put(shuffledCrews.get(i), shuffledCrews.get(i + 1));
        }
        if (crewsCnt % 2 == 1) {
            pairs.put(shuffledCrews.get(crewsCnt - 2), shuffledCrews.get(crewsCnt - 1));
            pairs.put(shuffledCrews.get(crewsCnt - 1), shuffledCrews.get(crewsCnt - 3));
        }
    }
}
