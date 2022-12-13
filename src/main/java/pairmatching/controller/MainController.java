package pairmatching.controller;

import pairmatching.domain.MenuCommand;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputview;
    private final OutputView outputView;
    private final PairController pairController;


    public MainController(InputView inputview, OutputView outputView){
        this.inputview = inputview;
        this.outputView = outputView;
        pairController = new PairController(inputview, outputView);
    }

    public void run(){
        MenuCommand command = MenuCommand.PAIR_INITIALIZE;
        while(!MenuCommand.QUIT.equals(command)){
            command = inputview.readMenuCommand();
            executeCommand(command);
        }
    }

    private void executeCommand(MenuCommand menuCommand){
        if(menuCommand.equals(MenuCommand.QUIT)){
            return;
        }
        pairController.executePairCommand(menuCommand);
    }
}
