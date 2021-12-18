package domain;

import java.util.Arrays;
import java.util.List;

import validation.CheckOption;
import view.InputView;
import view.OutputView;

public class MainController {
    private static final String PAIR_MATCHING = "1";
    private static final String PAIR_SEARCH = "2";
    private static final String PAIR_INITIALIZE = "3";
    private static final String EXIT_PROGRAM = "Q";
    
    public static void run() {
        List<String> options = Arrays.asList(PAIR_MATCHING,PAIR_SEARCH,PAIR_INITIALIZE,EXIT_PROGRAM);
        
        while(true) {
            OutputView.showMain();
            String option = selectOption(options);
            
            if(option.equals(EXIT_PROGRAM)) {
                break;
            }
           
            navigateSubMenu(option);
        }
    }
    
    private static String selectOption(List<String> options) {
        String option;
        while(true) {
            try {
                option = InputView.selectOption();
                CheckOption.checkValidOption(options, option);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return option;
    }
    
    private static void navigateSubMenu(String option) {
        if(option.equals(PAIR_MATCHING)) {
            OperationController.runMatchingManagement();
        }
        if(option.equals(PAIR_SEARCH)) {
            OperationController.runSearchingManagement();
        }
        if(option.equals(PAIR_INITIALIZE)) {
            System.out.println();
        }
    }
}

