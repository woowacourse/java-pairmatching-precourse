package pairmatching.controller;

import pairmatching.Initialize.Initializer;

import java.io.IOException;

public class MainController {
    private final Initializer initializer;


    public MainController() {
        this.initializer = new Initializer();
    }

    public void set() throws IOException {
        initializer.setBackCrew();
        initializer.setFrontCrew();
    }
}
