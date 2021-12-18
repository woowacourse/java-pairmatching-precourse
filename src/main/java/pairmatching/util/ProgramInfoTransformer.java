package pairmatching.util;

import static pairmatching.Constant.*;
import static pairmatching.ErrorMessage.*;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.ProgramInfo;
import pairmatching.repository.ProgramInfoRepository;

public class ProgramInfoTransformer {

    public static ProgramInfo makeProgramInfo(String programInfoBeforeProcessing) {
        String[] programInfoDetails = StringUtil.splitUsingComma(programInfoBeforeProcessing);
        validateDetailCntIsCorrect(programInfoDetails);
        Course course = Course.find(programInfoDetails[PROGRAM_COURSE_IDX]);
        Level level = Level.find(programInfoDetails[PROGRAM_LEVEL_IDX]);
        Mission mission = level.findMission(programInfoDetails[PROGRAM_MISSION_IDX]);

        return new ProgramInfo(course, level, mission);
    }

    private static void validateDetailCntIsCorrect(String[] programInfoDetails) {
        if (programInfoDetails.length != PROGRAM_INFO_SIZE) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }
}
