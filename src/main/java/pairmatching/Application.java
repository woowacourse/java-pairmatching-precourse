package pairmatching;

import java.util.ArrayList;

public class Application {
    public boolean process(String command) {
        if (command.equals("1")) {
            executePairMatching();
        }
        if (command.equals("2")) {

        }
        if (command.equals("3")) {

        }
        if (command.equals("Q")) {
            return false;
        }
        return true;
    }

    private void executePairMatching() {
        CoursesOutput.printCourseInformation();
        String command = InputCommand.getMatchingCommand();
    }

    public boolean processCommand() {
        OutputCommand.printGuide();
        try {
            String command = InputCommand.getCommand();
            if (!process(command)) {
                return false;
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void run() {
        BackEndManager backendManager = new BackEndManager();
        FrontEndManager frontEndManager = new FrontEndManager();
        while (processCommand()) {
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
