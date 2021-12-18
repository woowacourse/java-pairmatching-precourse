package validation;

import java.util.Arrays;

import domain.Course;
import domain.Level;

public class CheckCurriculumFormat {
    private static final String ERROR_MESSAGE_COURSE = "[ERROR] 존재하지 않는 과목입니다.";
    private static final String ERROR_MESSAGE_LEVEL = "[ERROR] 존재하지 않는 레벨입니다.";
    private static final String ERROR_MESSAGE_MISSION = "[ERROR] 존재하지 않는 미션입니다.";
    
    public static void checkCourse(String course) {
        if(!Arrays.stream(Course.values()).anyMatch(c -> c.getName().equals(course))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_COURSE);
        }
    }
    
    public static void checkLevel(String level) {
        if(!Arrays.stream(Level.values()).anyMatch(l -> l.getName().equals(level))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LEVEL);
        }
    }
    
    public static void checkMission(String level, String mission) {
        Level lev = Level.findByName(level);
        
        if(!lev.getMissions().stream().anyMatch(m -> m.equals(mission))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MISSION);
        }
    }

}
