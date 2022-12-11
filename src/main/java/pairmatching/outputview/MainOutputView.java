package pairmatching.outputview;

import pairmatching.vo.MainCommand;

public class MainOutputView {

    public static final String MAIN_MESSAGE = "기능을 선택하세요.";
    public static final String COMMAND_FORMAT = "%s. %s%n";

    public static void printCommands() {
        System.out.println();
        System.out.println(MAIN_MESSAGE);
        printCommandInfo();
    }

    private static void printCommandInfo() {
        for (MainCommand mainCommand : MainCommand.values()) {
            System.out.printf(COMMAND_FORMAT, mainCommand.getCommand(), mainCommand.getDescription());
        }
    }
}
