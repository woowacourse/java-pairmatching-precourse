package pairmatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Courses {
    private static final String MISSION_LV1 = "자동차경주,로또,숫자야구게임";
    private static final String MISSION_LV2 = "장바구니,결제,지하철노선도";
    private static final String MISSION_LV4 = "성능개선,배포";
    private static final String SPLIT_REGEX = ",";
    private static final int LV1 = 1;
    private static final int LV2 = 2;
    private static final int LV4 = 4;
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 5;

    private static Courses courses = null;
    private HashMap<Integer, ArrayList<String>> courseList;

    private Courses() {
        courseList = new HashMap<>();
        for (int level = MIN_LEVEL; level <= MAX_LEVEL; level++) {
            courseList.put(level, new ArrayList<String>());
        }
        init();
    }

    public static Courses getInstance() {
        if (courses == null) {
            courses = new Courses();
        }
        return courses;
    }

    private void init() {
        courseList.get(LV1).addAll(getCourseByString(MISSION_LV1));
        courseList.get(LV2).addAll(getCourseByString(MISSION_LV2));
        courseList.get(LV4).addAll(getCourseByString(MISSION_LV4));
    }

    private List<String> getCourseByString(String course) {
        return Arrays.stream(course.split(SPLIT_REGEX))
                .collect(Collectors.toList());
    }

    public ArrayList<String> getCourses(int level) {
        return courseList.get(level);
    }
}
