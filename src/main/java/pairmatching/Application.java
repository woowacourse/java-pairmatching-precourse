package pairmatching;

import java.io.IOException;

import pairmatching.domain.PairMatchingProgram;

public class Application {
    public static void main(String[] args) throws IOException {
        PairMatchingProgram pairMatching = new PairMatchingProgram();
        pairMatching.start();
    }
}
