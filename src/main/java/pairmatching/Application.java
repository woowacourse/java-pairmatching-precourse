package pairmatching;

import pairmatching.controller.MatchingController;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        MatchingController matchingController =  new MatchingController();
        while(true){
            String answer = matchingController.start();
            if(answer.equals("Q")){
                break;
            }
        }

    }
}
