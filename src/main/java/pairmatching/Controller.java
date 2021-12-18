package pairmatching;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Controller {
    Crews crews = new Crews();

    String input;
    public String[] courses;

    public void start() {
        crews.readFrontend();
        crews.readBackend();
        program();
    }

    private void program() {
        crews.createCourses();
        selectFunctions();
    }

    public void selectFunctions() {
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_FUNCTIONS);
            input();
            check = inputFunctions();
        }
        if (input.charAt(0) == '1') {
            selectCourses();
        }
        crews.matching(courses);

    }

    private boolean inputFunctions() {
        try {
            boolean check = checkFunctions();
            if (!check) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_INPUT);
            return false;
        }
        return true;
    }

    public void input() {
        input = String.valueOf(Console.readLine());
    }

    private boolean checkFunctions(){
        if (input.length() == 1 && (input.charAt(0) == '1' || input.charAt(0) == '2' || input.charAt(0) == '3' || input.charAt(0) == 'Q')) {
            return true;
        }
        return false;
    }

    private void selectCourses() {
        System.out.println(Message.PRINT_COURSES);
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_COURSES);
            input();
            check = inputCourses();
        }
        crews.findIndex(courses);
        if (crews.checkAlready(courses)) {
            selectAlready();
        }
    }

    private void selectAlready() {
        System.out.println(Message.ALREADY_EXISTS);
        input();
        if (input.equals("아니요")) {
            selectFunctions();
        }
    }

    private boolean inputCourses() {
        try {
            courses = input.split(", ");
            boolean check = checkCourses();
            if (!check) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_INPUT);
            return false;
        }
        return true;
    }

    private boolean checkCourses() {
        if (courses.length != 3 && !(courses[0].equals("벡엔드") || courses.equals("프론트엔드"))) {
            return false;
        }
        if (courses[1].equals("레벨1") && (courses[2].equals("자동차경주") || courses[2].equals("로또") || courses[2].equals("숫자야구게임"))) {
            return true;
        }
        if (courses[1].equals("레벨2") && (courses[2].equals("장바구니") || courses[2].equals("결제") || courses[2].equals("지하철노선도"))) {
            return true;
        }
        if (courses[1].equals("레벨4") && (courses[2].equals("성능개선") || courses[2].equals("배포"))) {
            return true;
        }
        return false;
    }
}
