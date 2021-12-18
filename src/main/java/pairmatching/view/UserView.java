package pairmatching.view;

import pairmatching.controller.mainmenu.Option;

import static camp.nextstep.edu.missionutils.Console.*;

public class UserView {
    public static final String DOT = ".";
    public static final String MAIN_MENU = "기능을 선택하세요.";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printOption(Option option) {
        System.out.println(option.getOption() + DOT + " " + option.getDetail());
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printBlankLine(){
        System.out.println();
    }

    public String readFromUser(){
        return readLine();
    }
}
