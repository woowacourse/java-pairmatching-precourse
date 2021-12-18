package pairmatching;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Console.*;

public class MatchingProgram {
    private boolean KEEP_MATCHING=true;

    public MatchingProgram(){
        while(KEEP_MATCHING){
            getAndPerformFunction();
        }
    }

    private void getAndPerformFunction(){
        MessagePrinter.printFunctions();
        while(true){
            try{
                String function=readLine();
                performFunctionOf(function);
                return;
            } catch(IllegalArgumentException e){
                System.out.println("[ERROR] 없는 기능입니다!");
            }
        }
    }

    private void performFunctionOf(String function){
        if(function.equals("1")){
            pairMatching();
            return;
        }
        if(function.equals("2")){
            pairViewing();
            return;
        }
        if(function.equals("3")){
            pairInitializing();
            return;
        }
        if(function.equals("Q")){
            quitProgram();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void pairMatching(){
        System.out.println("pairMatching");
    }

    private void pairViewing(){

        System.out.println("pairViewing");
    }

    private void pairInitializing(){

        System.out.println("pairInitializing");
    }

    private void quitProgram(){
        KEEP_MATCHING=false;
    }

}
