package pairmatching.controller;

import java.util.List;
import pairmatching.Setup;
import pairmatching.constants.InputConstants;
import pairmatching.domain.CrewRepository;
import pairmatching.domain.PairMemory;
import pairmatching.domain.PairMemoryRepository;
import pairmatching.domain.Section;
import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.views.InputView;
import pairmatching.views.OutputView;

public class MainController {
    private Setup setup;
    private PairMemoryRepository pairMemoryRepository;

    public MainController() {
        setup = new Setup();
        pairMemoryRepository = new PairMemoryRepository();
    }

    public void start() {
        while(true) {
            String function = "";
            try {
                function = InputView.getFunction();
            }catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            }
            if(function.equals(InputConstants.PAIR_QUIT)) {
                break;
            }
            figureFunction(function);
        }
    }

    public void figureFunction(String function) {
        if(function.equals(InputConstants.PAIR_MATCHING)) {
            pairMatching();
            return;
        }
        if(function.equals(InputConstants.PAIR_SEARCHING)) {
            return;
        }
        if(function.equals(InputConstants.PAIR_CLEAR)) {
            return;
        }
    }

    public void pairMatching() {
        OutputView.printSection();
        //TODO : 매칭하고자 하는 과정 레벨 미션 입력 받기
        getSection();
    }

    private Section getSection() {
        while(true) {
            try {
                Section section = InputView.getSection();
                return section;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
