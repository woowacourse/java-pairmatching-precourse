package pairmatching.repository.matching;

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
}
