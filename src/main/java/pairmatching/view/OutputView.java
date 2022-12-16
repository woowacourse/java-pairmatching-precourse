package pairmatching.view;

import pairmatching.view.message.Message;

public class OutputView {

    public void printCommandGuide() {
        print(Message.COMMAND_GUIDE.getMessage());
    }

    public void printChoiceGuide() {
        print(Message.CHOICE_GUIDE.getMessage());
    }

    public void printErrorMessage(String message) {
        print(message);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
