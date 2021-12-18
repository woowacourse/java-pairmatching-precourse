package view;

import domain.Course;
import domain.Mission;

public class OutputView {
    private static final String PAIR_MATCHING = "1. 페어매칭";
    private static final String PAIR_SEARCH = "2. 페어 조회";
    private static final String PAIR_INITIALIZE = "3. 페어 초기화";
    private static final String EXIT_PROGRAM = "Q. 종료";
    private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    
    public static void showMain() {
        System.out.println(PAIR_MATCHING);
        System.out.println(PAIR_SEARCH);
        System.out.println(PAIR_INITIALIZE);
        System.out.println(EXIT_PROGRAM);
    }
    
    public static void showMatchingResult(Course course, Mission mission) {
        System.out.println(PAIR_MATCHING_RESULT);
        if(course.equals(Course.BACKEND)) {
            for(int i = 0; i < mission.getBackendCrew().size()-1; i+=2) {
                System.out.println(mission.getBackendCrew().get(i) + ":" + mission.getBackendCrew().get(i+1));
            }
        }
        if(course.equals(Course.FRONTEND)) {
            for(int i = 0; i < mission.getFrontendCrew().size()-2; i+=2) {
                System.out.println(mission.getFrontendCrew().get(i) + ":" + mission.getBackendCrew().get(i+1));
                if(i == mission.getFrontendCrew().size()-2) {
                    System.out.println(mission.getFrontendCrew().get(i) + ":" + mission.getBackendCrew().get(i+1) + ":" + mission.getBackendCrew().get(i+2));
                    
                }
            }
        }
    }
    
    
}
