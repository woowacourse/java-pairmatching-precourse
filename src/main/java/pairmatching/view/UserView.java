package pairmatching.view;

import java.util.List;

import pairmatching.controller.mainmenu.Option;
import pairmatching.domain.course.Course;

import static camp.nextstep.edu.missionutils.Console.*;

public class UserView {
    public static final String DOT = ".";
    public static final String MAIN_MENU = "기능을 선택하세요.";
    public static final String DIVIDER = " | ";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printOption(Option option) {
        System.out.println(option.getOption() + DOT + " " + option.getDetail());
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printBlankLine() {
        System.out.println();
    }

    public String readFromUser() {
        return readLine();
    }

    public void printCourses(List<Course> courseList) {
        StringBuilder sb = new StringBuilder("과정: ");
        if(courseList.isEmpty()) {
            System.out.println(sb);
            return;
        }
        for(int i = 0 ; i< courseList.size() -1 ; i++) {
            sb.append(courseList.get(i).toString());
            sb.append(DIVIDER);
        }
        sb.append(courseList.get(courseList.size()-1).toString());
        System.out.println(courseList);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
