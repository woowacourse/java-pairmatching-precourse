package pairmatching.repository.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import pairmatching.domain.Pair;
import pairmatching.dto.MissionDto;

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

    public boolean isDuplicated(MissionDto dto, Set<Pair> pairs) {
        return levels.get(dto.getLevel() - 1).isDuplicated(pairs);
    }

    public void save(int level, String mission, Set<Pair> pairs) {
        levels.get(level - 1).save(mission, pairs);
    }

    public void removeHistory(MissionDto missionDto) {
        levels.get(missionDto.getLevel() - 1).removeHistory(missionDto.getMission());
    }
}
