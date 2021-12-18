package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private static final String SPLIT_REGEX = ",";

    public boolean process(String command) {
        if (command.equals("1")) {
            executePairMatching();
        }
        if (command.equals("2")) {
            executeInquirePairData();
        }
        if (command.equals("3")) {

        }
        if (command.equals("Q")) {
            return false;
        }
        return true;
    }

    private void executeInquirePairData() {
        CoursesOutput.printCourseInformation();
        String[] command = CommandInput.getMatchingCommand().split(SPLIT_REGEX);
        ArrayList<Pair> PairData = PairManager.getInstance().getPairData(
                command[0].trim(),
                command[1].trim().substring(2),
                command[2].trim()
        );
        PairOutput.printPairResult(PairData);
    }

    private void executePairMatching() {
        CoursesOutput.printCourseInformation();
        String[] command = CommandInput.getMatchingCommand().split(SPLIT_REGEX);
        PairManager.getInstance().executePairMatching(
                command[0].trim(),
                command[1].trim().substring(2),
                command[2].trim()
        );


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
