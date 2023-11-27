package pairmatching.repository.matching;

import java.util.Set;
import pairmatching.domain.Pair;
import pairmatching.dto.MissionDto;

public class MatchingHistory {
    private final CourseHistory backend;
    private final CourseHistory frontend;

    public MatchingHistory() {
        this.backend = new CourseHistory();
        this.frontend = new CourseHistory();
    }

    public boolean isMatched(MissionDto dto) {
        String course = dto.getCourse();
        if (course.equals("백엔드")) {
            return backend.isMatched(dto.getLevel(), dto.getMission());
        }
        if(course.equals("프론트엔드")){
            return frontend.isMatched(dto.getLevel(), dto.getMission());
        }

        //todo
        throw new IllegalArgumentException();
    }

    public boolean isDuplicated(MissionDto dto, Set<Pair> pairs){
        CourseHistory history = backend;
        if(dto.getCourse().equals("프론트엔드")){
            history = frontend;
        }
        return history.isDuplicated(dto, pairs);
    }

    public void save(MissionDto dto, Set<Pair> pairs){
        CourseHistory history = getHistory(dto.getCourse());
        history.save(dto.getLevel(), dto.getMission(), pairs);
    }

    private CourseHistory getHistory(String course){
        if(course.equals("백엔드")){
            return backend;
        }
        return frontend;
    }

    public void removeHistory(MissionDto missionDto) {
        CourseHistory history = getHistory(missionDto.getCourse());
        history.removeHistory(missionDto);
    }

    public Set<Pair> getResult(MissionDto missionDto) {
        CourseHistory history = getHistory(missionDto.getCourse());
        return history.getResult(missionDto);
    }
}
