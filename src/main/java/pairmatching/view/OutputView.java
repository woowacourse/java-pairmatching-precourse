package pairmatching.view;

import static pairmatching.messages.IOMessages.COURSE;
import static pairmatching.messages.IOMessages.MISSION;
import static pairmatching.messages.IOMessages.OUTPUT_DIVIDING_LINE;
import static pairmatching.messages.IOMessages.OUTPUT_PAIRMATCHING_RESULT;
import static pairmatching.messages.IOMessages.OUTPUT_RESET;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.dto.MatchingResultDto;
import pairmatching.domain.entity.Course;
import pairmatching.domain.entity.Level;
import pairmatching.domain.entity.Mission;

public class OutputView {

    public void outputCourseMission() {
        System.out.println(OUTPUT_DIVIDING_LINE.getMessage());

        outputCourses();
        outputMissions();

        System.out.println(OUTPUT_DIVIDING_LINE.getMessage());
    }

    public void outputPairMatchingResult(MatchingResultDto matchingResultDto) {
        System.out.println(OUTPUT_PAIRMATCHING_RESULT.getMessage());

        List<List<String>> matchings = matchingResultDto.getMatchingResult();
        matchings.stream()
                .map(this::formatPair)
                .forEach(System.out::println);
    }

    public void outputErrorMessage(String message) {
        System.out.println(message);
    }

    public void ouputReset() {
        System.out.println(OUTPUT_RESET.getMessage());
    }
    private String formatPair(List<String> list) {
        return String.join(" : ", list);
    }

    private void outputCourses() {
        String courses = Arrays.stream(Course.values())
                .map(Course::getDescription)
                .collect(Collectors.joining(" | "));
        System.out.println(COURSE.getMessage() + ": " + courses);
    }

    private void outputMissions() {
        System.out.println(MISSION.getMessage() + ": ");
        Arrays.stream(Level.values())
                .map(this::formatMissionsForLevel)
                .forEach(System.out::println);
    }

    private String formatMissionsForLevel(Level level) {
        String missions = level.getMissions()
                .stream()
                .map(Mission::getDescription)
                .collect(Collectors.joining(" | "));

        return "  - " + level.getDescription() + ": " + missions;
    }

}
