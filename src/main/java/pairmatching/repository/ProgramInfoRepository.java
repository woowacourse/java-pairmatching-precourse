package pairmatching.repository;

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
        Course course = nowProgramInfo.getCourse(); //백인지 프론트인지
        Level level = nowProgramInfo.getLevel(); // 몇 단계 미션인지
        //프로그램 info에게 course가 같냐? level이 같냐? 물어봄.
        // 같은 녀석을 찾으면 -> crew1과 crew2가 매칭된 적 있냐고 물어본다. true or false
        return programInfos.stream()
            .filter(programInfo -> programInfo.getCourse() == nowProgramInfo.getCourse())
            .filter(programInfo -> programInfo.getLevel() == nowProgramInfo.getLevel())
            .anyMatch(programInfo -> programInfo.isMatch(crew1, crew2));
        // 매치가 된 경우가 있으면 -> true

    }
}
