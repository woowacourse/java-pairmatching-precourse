package pairmatching.matching;

import pairmatching.GeneralInputView;

import java.util.Arrays;
import java.util.List;

public class MatchingController {
    private final MatchingService matchingService;

    public MatchingController() {
        matchingService = new MatchingService();
    }

    public String inputFunctionByUser() {
        String choice;
        try {
            String input = GeneralInputView.inputFunctionByClient();
            // 검증로직
            choice = input;

        } catch (IllegalArgumentException e) {
            choice = inputFunctionByUser();
        }
        return choice;
    }

    public String inputCourseByUser() {
        String selectCourse;
        try {
            String inputCourse = GeneralInputView.inputCourseByClient();
            // 검증 로직
            selectCourse = inputCourse;
        } catch (IllegalArgumentException e) {
            selectCourse = inputCourseByUser();
        }
        return selectCourse;
    }

    public List<String> makeListCourseInfo(){
        return Arrays.asList(inputCourseByUser().split(", "));
    }


    public void startMatching() {
        // 매칭 중복 확인로직
        // 매칭 로직
        // 결과보여주기
        MatchingOutputView.seeMatchingResult();
    }

    public void seeMatchingInfo() {
        List<String> courseInfo = makeListCourseInfo();
        // 결과 보여주기
        MatchingOutputView.seeMatchingResult();
    }

    public void resetMatching() {
        // 초기화 로직
        MatchingOutputView.resetFinishedPrint();
    }

}
