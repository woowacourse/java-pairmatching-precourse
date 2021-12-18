package pairmatching;

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
        String command = CommandInput.getMatchingCommand();
    }

    public boolean processCommand() {
        CommandOutput.printGuide();
        try {
            String command = CommandInput.getCommand();
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
        CrewManager crewManager = new CrewManager();
        while (processCommand()) {
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
