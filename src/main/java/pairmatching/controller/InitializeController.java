package pairmatching.controller;

import pairmatching.service.InitializeService;

import static pairmatching.view.OutputView.printInitialize;

public class InitializeController {
    public static final InitializeService initializeService = new InitializeService();

    public void run() {
        initializeService.matchInfo();
        printInitialize();
    }
}