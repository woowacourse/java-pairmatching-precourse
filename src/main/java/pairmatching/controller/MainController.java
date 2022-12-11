package pairmatching.controller;

import pairmatching.inputview.MainInputView;
import pairmatching.outputview.MainOutputView;
import pairmatching.system.ControllerHolder;
import pairmatching.vo.ControllerName;
import pairmatching.vo.MainCommand;

import java.util.Map;

public class MainController extends AbstractController {
    @Override
    public void doProcess(Map<String, Object> model) {
        MainCommand command;
        do {
            MainOutputView.printCommands();
            command = MainInputView.getCommand();

            doMatchingProcess(model, command);
            doFindingProcess(model, command);
            if (command == MainCommand.RESET) {
                ControllerHolder.get(ControllerName.RESET).process(model);
            }

        } while (command != MainCommand.QUIT);
    }

    private static void doFindingProcess(Map<String, Object> model, MainCommand command) {
        if (command == MainCommand.FIND) {
            ControllerHolder.get(ControllerName.FIND).process(model);
        }
    }

    private static void doMatchingProcess(Map<String, Object> model, MainCommand command) {
        if (command == MainCommand.MATCHING) {
            ControllerHolder.get(ControllerName.MATCHING).process(model);
        }
    }
}
