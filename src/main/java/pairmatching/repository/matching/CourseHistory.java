package pairmatching.repository.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CourseHistory {
    List<LevelHistory> levels = new ArrayList<>();

    public CourseHistory() {
        for (int i = 0; i < 5; i++) {
            levels.add(new LevelHistory());
        }
    }

    public boolean isMatched(int level, String mission) {
        return levels.get(level - 1).isMatched(mission);
    }

}
