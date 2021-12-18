package pairmatching;

import pairmatching.controller.Controller;
import pairmatching.domain.MatchingService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.choicePairMatching();
        try {
            MatchingService matchingService = new MatchingService();
            matchingService.match("프론트엔드");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
