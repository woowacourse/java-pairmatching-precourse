package pairmatching.controller;

import pairmatching.domain.InputDTO;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingRepository;
import pairmatching.service.InputService;
import pairmatching.service.PairService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairController {
    InputService inputService = new InputService();
    PairService pairService = new PairService();
    InputDTO inputDTO = null;

    public void matching() {
        setInputDTO();
        Matching result = pairService.matching(inputDTO);
        if (result == null) {
            OutputView.printError("매칭이 불가능합니다.");
            return;
        }
        OutputView.printPairs(result);
    }

    public void setInputDTO() {
        OutputView.printCourseAndMission();
        getInput();
        if (!MatchingRepository.isMatched(inputDTO)) {
            if (!inputService.parseRematch(InputView.isRematch())) {
                setInputDTO();
            }
        }
    }

    public void getInput() {
        try {
            String input = InputView.getInfo().replaceAll(" ", "");
            inputDTO = inputService.parseInput(input);
        } catch (IllegalArgumentException e) {
            getInput();
            OutputView.printError("입력형식에 맞춰 입력해주세요.");
        }
    }
}
