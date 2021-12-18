package pairmatching;

import java.io.FileNotFoundException;

import pairmatching.model.GameData;
import pairmatching.view.MatchingProgramInterface;
import pairmatching.view.classes.MatchingProgram;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        // MatchingProgramInterface matchingProgramInterface = new MatchingProgram();
        // matchingProgramInterface.start();
        try {
            GameData gameData = new GameData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
