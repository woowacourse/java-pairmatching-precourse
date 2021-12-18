package pairmatching;

import java.util.ArrayList;

public class Application {
    public boolean process(String command) {
        if (command.equals("1")) {

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

    public void run() {
        BackEndManager backendManager = new BackEndManager();
        FrontEndManager frontEndManager = new FrontEndManager();
        while (true) {
            OutputCommand.printGuide();
            String command = InputCommand.getCommand();
            if (!process(command)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.run();
    }
}
