package pairmatching.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public Crews requestBackendCrews(){
        File file = new File(BACKEND_CREW_RESOURCE_PATH);
        Crews crews = new Crews();
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(file));
            addBackendCrews(crews, inputFile);
            return crews;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 파일 입력에 문제가 발생하였습니다.");
        }
    }

    private void addBackendCrews(Crews crews, BufferedReader inputFile) throws IOException {
        String input = "";
        while( (input = inputFile.readLine()) != null ) {
            crews.add(new Crew(Course.BACKEND, input));
        }
    }

    public Crews requestFrontendCrews() {
        File file = new File(FRONTEND_CREW_RESOURCE_PATH);
        Crews crews = new Crews();
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader(file));
            addFrontendCrews(crews, inputFile);
            return crews;
        } catch (Exception e) {
            throw new IllegalArgumentException(FILE_INPUT_EXCEPTION);
        }
    }

    private void addFrontendCrews(Crews crews, BufferedReader inputFile) throws IOException {
        String input = "";
        while( (input = inputFile.readLine()) != null ) {
            crews.add(new Crew(Course.FRONTEND, input));
        }
    }
}
