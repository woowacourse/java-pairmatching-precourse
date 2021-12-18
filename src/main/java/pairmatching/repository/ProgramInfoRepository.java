package pairmatching.repository;

import static pairmatching.ErrorMessage.*;

import java.util.ArrayList;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.ProgramInfo;

public class ProgramInfoRepository {
    ArrayList<ProgramInfo> programInfos = new ArrayList<>();

    public void add(ProgramInfo programInfo) {
        programInfos.add(programInfo);
    }

    public boolean hasProgramInfo(ProgramInfo nowProgramInfo) {
        return programInfos.stream().anyMatch(programInfo -> programInfo.equals(nowProgramInfo));
    }

    public void delete(ProgramInfo programInfo) {
        programInfos.remove(programInfo);
    }

    public boolean checkTwoCrewsAlreadyMatch(ProgramInfo nowProgramInfo, Crew crew1, Crew crew2) {
        return programInfos.stream()
            .filter(programInfo -> programInfo.getCourse() == nowProgramInfo.getCourse())
            .filter(programInfo -> programInfo.getLevel() == nowProgramInfo.getLevel())
            .anyMatch(programInfo -> programInfo.isMatch(crew1, crew2));
        // 매치가 된 경우가 있으면 -> true

    }

    public void clearAllMatchingInfo() {
        programInfos.stream().forEach(programInfo -> programInfo.clearPairs());
    }

    public void clearAllProgramInfo() {
        clearAllMatchingInfo();
        programInfos.clear();
    }

    public ProgramInfo getSameProgramInfo(ProgramInfo notProgramInfo) {
        return programInfos.stream()
            .filter(eachProgramInfo -> eachProgramInfo.equals(notProgramInfo))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(NO_OBJECT_ERROR));
    }
}
