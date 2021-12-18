package pairmatching;

import java.io.IOException;

import outputcontroller.ApplicationUI;
import inputcontroller.inputGenerator;
import inputcontroller.modelGenerator;

public class Application {
    public static void main(String[] args) {
        MatchMain.initMatch();

        while (true) {
            ApplicationUI.printUI();
            char inputNumber = inputGenerator.inputFunctionChoice();
            if (inputNumber == 'Q') {
                return;
            }
            MatchMain.doFunction(inputNumber);
        }


    }
}
