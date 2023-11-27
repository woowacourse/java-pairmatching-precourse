package domain.dto;

import domain.entity.CourseMission;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.StringUtil;

public class CourseMissionMapper {
    public static CourseMission toCourseMission(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);
        List<String> separated = Arrays.stream(input.split(","))
                .collect(Collectors.toList()); //실전에선 toList() 사용

        return CourseMission.create(separated);
    }
}
