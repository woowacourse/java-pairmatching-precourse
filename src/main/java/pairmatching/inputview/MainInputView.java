package pairmatching.inputview;

import pairmatching.vo.MainCommand;

public class MainInputView extends AbstractInputView {
    public static MainCommand getCommand() {
        return MainCommand.findByCommand(readInput());
    }
}
