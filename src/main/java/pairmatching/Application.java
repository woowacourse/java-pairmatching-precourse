package pairmatching;


import pairmatching.controller.Matching;

public class Application {

    public static void main(String[] args) {
        Runnable matching = new Matching();
        matching.run();
    }
}
