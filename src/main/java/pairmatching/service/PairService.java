package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MissionRepository;
import pairmatching.view.InputView;
import pairmatching.view.Message.ErrorMessage;
import pairmatching.view.Message.QuestionMessage;
import pairmatching.view.OutputView;

import java.io.IOException;

import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static pairmatching.view.Message.QuestionMessage.printQuestionRematch;
import static pairmatching.view.Message.ResetMessage.printReset;

public class PairService {

    private MatchService matchService;
    public PairService(){
        this.matchService = new MatchService();
    }

    public boolean makeMatching(Course course, Level level, Mission mission) throws IOException {
        mission.removeMatching();
        List<String> crewNameList = matchService.makeCrewNameList(course);
        int count = 0;
        while(count < 3) {
            crewNameList = shuffle(crewNameList);
            try {
                if (matchService.isEven(crewNameList)) {
                    Mission matchedMission = matchService.evenMatch(crewNameList, level, mission);
                    OutputView.printMatching(matchedMission);
                }

                if (!matchService.isEven(crewNameList)) {
                    Mission matchedMission = matchService.oddMatch(crewNameList, level, mission);
                    OutputView.printMatching(matchedMission);
                }
            } catch (IllegalArgumentException e) {
                count += 1;
                if (count == 3) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            count += 1;
        }
        return false;
    }

    public boolean getPair(Course course, Level level, Mission mission) throws IOException {
        if (mission.isExistMatchingCrews()) {
            printQuestionRematch();
            String input = InputView.input();
            if (input.equals("네")) {
                mission.removeMatching();
                makeMatching(course, level, mission);
                return false;
            }
            mission.printPair();
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.NO_MATCH);
    }


    public boolean removePair(Course course, Level level, Mission mission) {
        mission.removeMatching();
        printReset();
        return false;
    }


}
