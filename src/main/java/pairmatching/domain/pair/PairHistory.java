package pairmatching.domain.pair;

import java.util.ArrayList;
import java.util.HashMap;

import pairmatching.domain.ErrorMessage;
import pairmatching.domain.course.Course;
import pairmatching.domain.crew.Crew;
import pairmatching.domain.crew.CrewRepository;

public class PairHistory {
    public static final String PAIRHIST_ERROR_CREW_ALREADY_MET_CREW = "크루가 이미 해당 크루를 만난적이 있습니다.";
    public static final String PAIRHIST_ERROR_CREW_NOT_EXIST = "해당크루가 매칭기록에 존재하지 않습니다.";

    private final HashMap<Crew, ArrayList<Crew>> crewMap = new HashMap<>();
    private final Course course;

    public PairHistory(Course course) {
        this.course = course;
        initHistory();
    }

    public Course getCourse() {
        return course;
    }

    public void deleteAllHistory() {
        crewMap.clear();
    }

    public void setCrewMetCrew(Crew crew1, Crew crew2) {
        checkCrewExist(crew1);
        checkCrewExist(crew2);
        crewMap.get(crew1).add(crew2);
        crewMap.get(crew2).add(crew1);
    }

    public boolean isCrewMetCrewBefore(Crew crew1, Crew crew2) {
        checkCrewExist(crew1);
        checkCrewExist(crew2);
        return crewMap.get(crew1).contains(crew2);
    }

    private void initHistory() {
        CrewRepository.checkCrewRepoIsEmpty();
        deleteAllHistory();
        for (Crew crew : CrewRepository.getCrewsOfCourse(course)) {
            crewMap.put(crew, new ArrayList<Crew>());
        }
    }

    private void checkCrewExist(Crew crew) {
        if (!crewMap.containsKey(crew)) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIRHIST_ERROR_CREW_NOT_EXIST));
        }
    }

    private void checkCrewDidNotMetCrew(Crew crew1, Crew crew2) {
        if (isCrewMetCrewBefore(crew1, crew2)) {
            throw new IllegalArgumentException(ErrorMessage.makeErrorMessage(
                PAIRHIST_ERROR_CREW_ALREADY_MET_CREW));
        }
    }
}
