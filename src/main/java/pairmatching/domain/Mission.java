package pairmatching.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import pairmatching.exception.MissionNotFoundMatchException;

public class Mission {

    private List<Match> matches;
    private final String name;
    private final Course course;

    public Mission(List<Match> matches, String name, Course course) {
        this.matches = matches;
        this.name = name;
        this.course = course;
    }

    public static Mission createEmptyMission(String name, Course course) {
        return new Mission(new ArrayList<>(), name, course);
    }

    public String name() {
        return name;
    }

    public Course course() {
        return course;
    }

    public boolean containAlreadyMatchCrew(Match match) {
        return matches.stream()
            .anyMatch(match1 -> match1.isSameMatch(match));
    }

    public boolean isEqualsMission(Mission mission) {
        return this.course.equals(mission.course) && this.name.equals(mission.name);
    }

    public boolean isMatched() {
        return matches.size() != 0;
    }

    public void updateMatch(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> matches() {
        checkMatchIsEnd();
        return Collections.unmodifiableList(new ArrayList<>(matches));
    }

    private void checkMatchIsEnd() {
        if (!isMatched()) {
            throw new MissionNotFoundMatchException();
        }
    }

    public void clearMatch() {
        matches = new ArrayList<>();
    }
}
