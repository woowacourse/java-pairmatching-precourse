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
        Section section = null;
        while(true) {
            section = getSection();
            if (!checkExistSection(section)) {
                break;
            }
            if(getRematch()) {
                break;
            }
        }
        startMatch(section);
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

    private boolean checkExistSection(Section section) {
        try {
            pairMemoryRepository.searchPairMemory(section);
            return true;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean getRematch() {
        while(true) {
            try {
                String rematch = InputView.getRematch();
                return rematch.equals(InputConstants.REMATCH_YES);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void startMatch(Section section) {
        List<List<String>> pairs = getPairs(section.getCourse());
        PairMemory pairMemory = new PairMemory(section, pairs);
        try {
            validatePairs(pairMemory);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        pairMemoryRepository.addPairMemory(pairMemory);
        // TODO : 매칭결과 프린트
        OutputView.printPairResult(pairs);
    }

    private List<List<String>> getPairs(Course course) {
        if(course.equals(Course.BACKEND)) {
            return CrewRepository.makeBackendPair();
        }
        return CrewRepository.makeFrontendPair();
    }

    private void validatePairs(PairMemory pairMemory) {
        for(int i = 0; i < 3; i++) {
            try {
                pairMemoryRepository.validatePairMemory(pairMemory);
                return;
            }catch (IllegalArgumentException e) {

            }
        }
        throw new IllegalArgumentException("[ERROR] 경우의 수가 없습니다.");
    }
}
