package pairmatching.matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Matching {
    private static final int LEVEL_COUNTS = 5;
    private static final int COURSE_COUNTS = 2;
    private static final int LEVEL_SIZE = 3;

    private final List<List<String>> course;
    private final HashMap<String, Integer> hashMap;

    public Matching() {
        course = new ArrayList<>();
        for (int i = 0; i < LEVEL_COUNTS * LEVEL_SIZE * COURSE_COUNTS; i++) {
            course.add(new ArrayList<>());
        }
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
        hashMap.put("", 8);
    }

    private void initFrontendHashMap() {
        hashMap.put("프론트엔드, 레벨1, 자동차경주", 9);
        hashMap.put("프론트엔드, 레벨1, 로또", 10);
        hashMap.put("프론트엔드, 레벨1, 숫자야구게임", 11);
        hashMap.put("프론트엔드, 레벨2, 장바구니", 12);
        hashMap.put("프론트엔드, 레벨2, 결제", 13);
        hashMap.put("프론트엔드, 레벨2, 지하철노선도", 14);
        hashMap.put("프론트엔드, 레벨4, 성능개선", 15);
        hashMap.put("프론트엔드, 레벨4, 배포", 16);
    }

    public boolean checkRightCourseName(String courseName) {
        return hashMap.containsKey(courseName);
    }

    public List<Integer> getSameLevelIndexList(String courseName) {
        checkRightCourseName(courseName);
        Integer index = hashMap.get(courseName);
        if (index == 6 || index == 7 || index == 15 || index == 16) {
            return Arrays.asList(index / LEVEL_SIZE, index / LEVEL_SIZE + 1);
        }
        return Arrays.asList(index / LEVEL_SIZE, index / LEVEL_SIZE + 1, index / LEVEL_SIZE + 2);
    }

    public boolean HasDuplicateMatchingBySameLevel(List<Integer> sameLevelIndexList) {
        List<String> allMatched = new ArrayList<>();
        for (Integer sameLevelIndex : sameLevelIndexList) {
            for(String matching: course.get(sameLevelIndex)){
                allMatched.add(matching);
            }
            //allMatched.addAll(course.get(sameLevelIndex));
        }
        return allMatched.stream().distinct().count() != allMatched.size();
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
