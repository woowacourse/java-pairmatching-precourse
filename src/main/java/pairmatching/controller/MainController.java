package pairmatching.controller;

import pairmatching.Initialize.Initializer;
import pairmatching.view.Menu.InputView;

import java.io.IOException;

import static pairmatching.view.Menu.MainMenu.printMainMenu;

public class MainController {
    private final Initializer initializer;


    public MainController() {
        this.initializer = new Initializer();
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
                // TODO : Validation - 입력없는경우, 유효한 메뉴 아닌경우
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
