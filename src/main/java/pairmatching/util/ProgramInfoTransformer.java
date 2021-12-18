package pairmatching.util;

import static pairmatching.Constant.*;
import static pairmatching.ErrorMessage.*;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.ProgramInfo;

public class ProgramInfoTransformer {
    public static ProgramInfo makeProgramInfo(String programInfoBeforeProcessing) { //입력으로 "백엔드, 레벨1, 자동차경주" 일케 주어짐.
        String[] programInfoDetails = StringUtil.splitUsingComma(programInfoBeforeProcessing);
        // 세 개가 아니면 -> 예외
        if (programInfoDetails.length != PROGRAM_INFO_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
        Course course = Course.find(programInfoDetails[PROGRAM_COURSE_IDX]);
        Level level = Level.find(programInfoDetails[PROGRAM_LEVEL_IDX]);
        Mission mission = level.findMission(programInfoDetails[PROGRAM_MISSION_IDX]);
        // 만들어진 걸 바탕으로 ProgramInfo를 만들어서 반환.
        System.out.println(course.getName());
        System.out.println(level.getName());
        System.out.println(mission.getName());
        return new ProgramInfo(course, level, mission);

    }
}
