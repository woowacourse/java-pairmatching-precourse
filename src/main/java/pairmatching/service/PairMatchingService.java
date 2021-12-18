package pairmatching.service;

import static pairmatching.ErrorMessage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.ProgramInfo;
import pairmatching.util.Initializer;

public class PairMatchingService {
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
        ArrayList<Crew> chosenCrews = getCrewsUsingCourse(programInfo);

        List<Crew> shuffledCrews = Randoms.shuffle(chosenCrews);
        for (int i = 0; i <shuffledCrews.size()/2; i++) {
            // shuffledCrews.get(i), shuffledCrews.get(i+1) 가 pair가 된 적 있는지 비교한다.
        }
        // 홀수였다면 -> shuffledCrews.get(끝), (끝-1) // (끝),(끝-2) // (끝-1), (끝-2)((사실 애는 이미 비교가됨.) 를 각각 비교해준다.

        // 만약 3회 이상 반복이 되면 예외를 반환한다. -> 만드는 걸 실패했습니다.

        // 3번 전에 제대로 만들어지면 -> 저 리스트를 2개씩 짝지어 pair라는 이름으로 반환해준다.
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
}
