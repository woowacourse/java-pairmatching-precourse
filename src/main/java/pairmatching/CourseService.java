package pairmatching;

import static pairmatching.Message.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CourseService {
    public String getCourseList() {
        StringBuilder result = new StringBuilder();
        result.append(DIVIDE_LINE + "\n");
        result.append("과정: ");
        result.append(Arrays.stream(Course.values())
                .map(String::valueOf)
                .collect(Collectors.joining(" | ")));
        return result.toString();
    }

    public void isExistCourse(String input) throws IllegalArgumentException {
        boolean exist = false;
        for (Course c : Course.values()) {
            if (c.getName().equals(input)) {
                exist = true;
            }
        }
        if (!exist) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 코스 이름입니다.");
        }
    }
}
