package pairmatching.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pairmatching.domain.course.enums.CourseEnum;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.matching.MatchingCondition;
import pairmatching.domain.menu.Menu;
import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.rematch.RematchInput;

public class InputView {

    public static final String REQUEST_MENU = "기능을 선택하세요";
    public static final String PAIR_MATCHING_MENU = "1. 페어 매칭";
    public static final String PAIR_READ_MENU = "2. 페어 조회";
    public static final String PAIR_INITIALIZATION_MENU = "3. 페어 초기화";
    public static final String QUIT_MENU = "Q. 종료";
    public static final String BACKEND_CREW_RESOURCE_PATH = "src/main/resources/backend-crew.md";
    public static final String REMATCH_OPTIONS = "네 | 아니오";
    private static final String FRONTEND_CREW_RESOURCE_PATH = "src/main/resources/frontend-crew.md";
    public static final String REQUEST_MATCHING_CONDITION = "과정, 레벨, 미션을 선택하세요.";
    public static final String MATCHING_CONDITION_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    public static final String REQUEST_REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";

    public static Menu requestMenuSelect() {
        try {
            showMenu();
            return new Menu(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMenuSelect();
        }
    }

    private static void showMenu() {
        System.out.println(REQUEST_MENU);
        System.out.println(PAIR_MATCHING_MENU);
        System.out.println(PAIR_READ_MENU);
        System.out.println(PAIR_INITIALIZATION_MENU);
        System.out.println(QUIT_MENU);
    }

    public static List<Crew> requestBackendCrews() {
        List<Crew> crews = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(BACKEND_CREW_RESOURCE_PATH));
            while (scanner.hasNext()) {
                String crewName = scanner.next();
                crews.add(new Crew(CourseEnum.BACKEND, crewName));
            }
            return crews;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return requestBackendCrews();
        }
    }

    public static List<Crew> requestFrontendCrews() {
        List<Crew> crews = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(FRONTEND_CREW_RESOURCE_PATH));
            while (scanner.hasNext()) {
                String crewName = scanner.next();
                crews.add(new Crew(CourseEnum.FRONTEND, crewName));
            }
            return crews;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return requestBackendCrews();
        }
    }

    public static MatchingCondition requestMatchingCondition() {
        try {
            System.out.println(REQUEST_MATCHING_CONDITION);
            System.out.println(MATCHING_CONDITION_EXAMPLE);
            return new MatchingCondition(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMatchingCondition();
        }
    }

    public static RematchInput requestRematch() {
        try {
            System.out.println(REQUEST_REMATCH);
            System.out.println(REMATCH_OPTIONS);
            return new RematchInput(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestRematch();
        }
    }
}
