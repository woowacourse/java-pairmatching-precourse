package pairmatching.controller;

import pairmatching.constant.ErrorConstant;
import pairmatching.service.InitService;
import pairmatching.view.OutputView;

import java.io.IOException;

public class InitController {
    InitService service = new InitService();

    public void init() {
        try {
            service.initialize();
        } catch (IOException e) {
            OutputView.printError(ErrorConstant.READ_FILE);
        }
    }
}
