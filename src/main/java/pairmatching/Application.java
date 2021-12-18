package pairmatching;

import pairmatching.play.PlayController;
import pairmatching.play.PlayView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO 구현 진행
        PlayController playController = new PlayController();
        playController.playGame();
    }
}
