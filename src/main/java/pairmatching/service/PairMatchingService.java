package pairmatching.service;

import static pairmatching.Constant.*;
import static pairmatching.ErrorMessage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;
import pairmatching.repository.ProgramInfoRepository;
import pairmatching.util.Initializer;

public class PairMatchingService {
    ProgramInfoRepository programInfoRepository = new ProgramInfoRepository();
    ArrayList<Crew> backEndCrews;
    ArrayList<Crew> frontEndCrews;

    public PairMatchingService() {
        registerCrews();
    }

    private void registerCrews(){
        try {
            backEndCrews = Initializer.registerBackEndCrews();
            frontEndCrews = Initializer.registerFrontEndCrews();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void matchPairs(ProgramInfo programInfo) {
        int repeatCntBecauseAlreadyMeet = 0;
        boolean alreadyMatch;
        List<Crew> shuffledCrews;
        do {
            ArrayList<Crew> chosenCrews = getCrewsUsingCourse(programInfo);
            shuffledCrews = Randoms.shuffle(chosenCrews);
            alreadyMatch = isAlreadyMatch(shuffledCrews, programInfo);
            repeatCntBecauseAlreadyMeet += 1;
        } while (alreadyMatch & repeatCntBecauseAlreadyMeet <= MATCHING_TRY_CNT);
        validateCanMakePair(repeatCntBecauseAlreadyMeet);
        programInfo.savePairs(shuffledCrews);
        programInfoRepository.add(programInfo);
    }

    private void validateCanMakePair(int repeatCntBecauseAlreadyMeet) {
        if (repeatCntBecauseAlreadyMeet > MATCHING_TRY_CNT) {
            throw new IllegalArgumentException(CANT_MAKE_PAIR_ERROR);
        }
    }

    private boolean isAlreadyMatch(List<Crew> shuffledCrews, ProgramInfo programInfo) {
        boolean alreadyMatch = false;
        int crewsCnt = shuffledCrews.size();
        for (int i = 0; i < crewsCnt / 2; i++) {
            alreadyMatch = programInfoRepository.checkTwoCrewsAlreadyMatch(programInfo, shuffledCrews.get(i * 2),
                shuffledCrews.get(i * 2 + 1));
            if (alreadyMatch) {
                return alreadyMatch;
            }
        }
        if (crewsCnt % 2 == 1) {
            alreadyMatch = isAlreadyMatchOnLastThreeCrew(programInfo, shuffledCrews, crewsCnt);
        }
        return alreadyMatch;
    }

    private boolean isAlreadyMatchOnLastThreeCrew(ProgramInfo programInfo, List<Crew> shuffledCrews, int crewsCnt) {
        boolean alreadyMatch;
        alreadyMatch = programInfoRepository.checkTwoCrewsAlreadyMatch(programInfo, shuffledCrews.get(crewsCnt - 1),
            shuffledCrews.get(crewsCnt - 2)) | programInfoRepository.checkTwoCrewsAlreadyMatch(programInfo,
            shuffledCrews.get(crewsCnt - 1),
            shuffledCrews.get(crewsCnt - 3));
        return alreadyMatch;
    }

    private ArrayList<Crew> getCrewsUsingCourse(ProgramInfo programInfo) {
        Course course = programInfo.getCourse();
        if (course == Course.BACKEND) {
            return backEndCrews;
        }
        if (course == Course.FRONTEND) {
            return frontEndCrews;
        }
        throw new IllegalArgumentException(LOGIC_ERROR);
    }

    public boolean isAlreadyMatching(ProgramInfo programInfo) {
        return programInfoRepository.hasProgramInfo(programInfo);
    }

    public boolean hasProgramInfo(ProgramInfo programInfo) {
        return programInfoRepository.hasProgramInfo(programInfo);
    }

    public void clearAllMatchingInfo() {
        programInfoRepository.clearAllProgramInfo();
    }

    public ProgramInfo getThisProgramInfo(ProgramInfo programInfo) {
        return programInfoRepository.getSameProgramInfo(programInfo);
    }
}
