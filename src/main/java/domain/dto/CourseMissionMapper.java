package domain.dto;

import domain.entity.Course;
import domain.entity.CourseMission;
import domain.entity.Level;
import domain.entity.Mission;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.StringUtil;

public class CourseMissionMapper {
    public static CourseMission toCourseMission(String input) {
        List<String> separated = seperate(input);

        final String courseName = separated.get(0);
        final String levelName = separated.get(1);
        final String missionName = separated.get(2);

        Course course = toCourse(courseName);
        Level level = toLevel(levelName);
        Mission mission = toMission(level, missionName);

        return CourseMission.create(course, level, mission);
    }

    private static List<String> seperate(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);
        List<String> separated = Arrays.stream(deleteSpaces.split(","))
                .collect(Collectors.toList()); //실전에선 toList() 사용
        return separated;
    }

    private static Level toLevel(String levelName) {
        return Level.findLevel(levelName);
    }

    private static Course toCourse(String courseName) {
        return Course.findCourse(courseName);
    }

    private static Mission toMission(Level level, String missionName) {
        return level.findMission(missionName);
    }
}
