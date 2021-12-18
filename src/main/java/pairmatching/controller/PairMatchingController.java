package pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.dto.CourseDto;
import pairmatching.dto.LevelDto;

public class PairMatchingController {
    private static final PairMatchingController pairMatchingController = new PairMatchingController();

    private PairMatchingController(){

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
}
