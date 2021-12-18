package pairmatching.controller;

import pairmatching.Initialize.Initializer;
import pairmatching.validation.MenuValidation;
import pairmatching.view.Menu.InputView;
import pairmatching.view.Message.ErrorMessage;

import java.io.IOException;

import static pairmatching.view.Menu.MainMenu.printMainMenu;

public class MainController {
    private final Initializer initializer;
    private final MenuValidation menuValidation;


    public MainController() {
        this.initializer = new Initializer();
        this.menuValidation = new MenuValidation();
    }

    public void set() throws IOException {
        initializer.setBackCrew();
        initializer.setFrontCrew();
    }

    public void run(){
        boolean runStatus = true;
        while(runStatus){
            try{
                printMainMenu();
                String input = InputView.input();
                menuValidation.checkNull(input);
                runStatus = selectMenu(input);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean selectMenu(String input){
        if(input.equals("1")){
            return true;
        }
        if(input.equals("2")){
            return true;
        }
        if(input.equals("3")){
            return true;
        }
        if(input.equals("Q")){
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.NO_MENU);
    }

}
