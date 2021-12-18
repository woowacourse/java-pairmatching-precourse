package pairmatching.matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Matching {
    private final List<List<String>> course;
    private final HashMap<String, Integer> hashMap;

    public Matching() {
        course = new ArrayList<>();
        hashMap = new HashMap<>();
        initBackendHashMap();
        initFrontendHashMap();
    }

    private void initBackendHashMap() {
        hashMap.put("백엔드, 레벨1, 자동차경주", 0);
        hashMap.put("백엔드, 레벨1, 로또", 1);
        hashMap.put("백엔드, 레벨1, 숫자야구게임", 2);
        hashMap.put("백엔드, 레벨2, 장바구니", 3);
        hashMap.put("백엔드, 레벨2, 결제", 4);
        hashMap.put("백엔드, 레벨2, 지하철노선도", 5);
        hashMap.put("백엔드, 레벨4, 성능개선", 6);
        hashMap.put("백엔드, 레벨4, 배포", 7);
    }

    private void initFrontendHashMap() {
        hashMap.put("프론트엔드, 레벨1, 자동차경주", 8);
        hashMap.put("프론트엔드, 레벨1, 로또", 9);
        hashMap.put("프론트엔드, 레벨1, 숫자야구게임", 10);
        hashMap.put("프론트엔드, 레벨2, 장바구니", 11);
        hashMap.put("프론트엔드, 레벨2, 결제", 12);
        hashMap.put("프론트엔드, 레벨2, 지하철노선도", 13);
        hashMap.put("프론트엔드, 레벨4, 성능개선", 14);
        hashMap.put("프론트엔드, 레벨4, 배포", 15);
    }

    public List<String> getMatching(String courseName) {
        return course.get(hashMap.get(courseName));
    }

    public boolean alreadyHasMatching(String courseName) {
        Integer courseIndex = hashMap.get(courseName);
        return course.get(courseIndex).size() > 0;
    }

    public void initCourseMatching() {
        for (List<String> eachCourse : course) {
            eachCourse.clear();
        }
        course.clear();
    }
}
