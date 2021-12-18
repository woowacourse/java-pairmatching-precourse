package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.dto.CourseDto;
import pairmatching.dto.LevelDto;
import pairmatching.dto.PairDto;
import pairmatching.dto.RequestDto;
import pairmatching.service.PairService;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private static final PairMatchingController pairMatchingController = new PairMatchingController();

    private final PairService pairService;

    private PairMatchingController(){
        pairService = new PairService();
    }

    public static PairMatchingController getInstance() {
        return pairMatchingController;
    }

    public List<CourseDto> requestProcess() {
        return Arrays.stream(Course.values()).map(CourseDto::new).collect(Collectors.toList());
    }

    public List<LevelDto> requestMission() {
        return Arrays.stream(Level.values()).map(LevelDto::new).collect(Collectors.toList());
    }

    public void match(RequestDto requestDto) {
        List<PairDto> pairDtos = pairService.match(requestDto);
        OutputView.printMatchingResult(pairDtos);
    }

    public boolean hasAlreadyMatching(RequestDto requestDto) {
        return pairService.hasAlreadyMatching(requestDto);
    }

    public void requestPairMatching(RequestDto requestDto) {
        OutputView.printMatchingResult(pairService.getPair(requestDto));
    }
}
