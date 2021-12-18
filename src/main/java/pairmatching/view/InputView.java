package pairmatching.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.Crews;
import pairmatching.domain.menu.Menu;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String REQUEST_MENU = "기능을 선택하세요";
    public static final String PAIR_MATCHING_MENU = "1. 페어 매칭";
    public static final String PAIR_READ_MENU = "2. 페어 조회";
    public static final String PAIR_INITIALIZATION_MENU = "3. 페어 초기화";
    public static final String QUIT_MENU = "Q. 종료";
    public static final String BACKEND_CREW_RESOURCE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_RESOURCE_PATH = "src/main/resources/frontend-crew.md";
    public static final String FILE_INPUT_EXCEPTION = "[ERROR] 파일 입력에 문제가 발생하였습니다.";

    public Menu requestMenuSelect() {
        try {
            showMenu();
            return new Menu(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return requestMenuSelect();
        }
    }

    private void showMenu() {
        System.out.println(REQUEST_MENU);
        System.out.println(PAIR_MATCHING_MENU);
        System.out.println(PAIR_READ_MENU);
        System.out.println(PAIR_INITIALIZATION_MENU);
        System.out.println(QUIT_MENU);
    }

    public Crews requestBackendCrews() {
        Crews crews = new Crews();
        try {
            Scanner scanner = new Scanner(new File(BACKEND_CREW_RESOURCE_PATH));
            while (scanner.hasNext()) {
                String crewName = scanner.next();
                crews.add(new Crew(Course.BACKEND, crewName));
            }
            return crews;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return requestBackendCrews();
        }
    }

    public Crews requestFrontendCrews() {
        Crews crews = new Crews();
        try {
            Scanner scanner = new Scanner(new File(FRONTEND_CREW_RESOURCE_PATH));
            while (scanner.hasNext()) {
                String crewName = scanner.next();
                crews.add(new Crew(Course.FRONTEND, crewName));
            }
            return crews;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return requestBackendCrews();
        }
    }
}
