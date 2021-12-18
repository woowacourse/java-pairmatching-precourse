package pairmatching;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.mode.Command;
import pairmatching.mode.PairMatchingService;
import pairmatching.util.CrewNameFIleReader;

public class PairMatchingRunner implements Runnable {
    static {
        List<String> backendNames = CrewNameFIleReader.createBackendNames();
        List<String> frontendNames = CrewNameFIleReader.createFrontendNames();

        backendNames.forEach(name -> CrewRepository.addCrew(new Crew(Course.BACKEND, name)));
        frontendNames.forEach(name -> CrewRepository.addCrew(new Crew(Course.FRONTEND, name)));
    }

    @Override
    public void run() {
        initMissions();
        inputMode();
    }

    private void inputMode() {
        while (true) {
            try {
                System.out.println("기능을 선택하세요.\n"
                    + "1. 페어 매칭\n"
                    + "2. 페어 조회\n"
                    + "3. 페어 초기화\n"
                    + "Q. 종료");
                String inputCommand = Console.readLine();
                if (Answer.isExit(inputCommand)) {
                    break;
                }
                PairMatchingService service = Command.findServiceByCommand(inputCommand);
                service.run();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void initMissions() {
        MissionRepository.addMission(new Mission(Level.LEVEL1, "자동차경주"));
        MissionRepository.addMission(new Mission(Level.LEVEL1, "로또"));
        MissionRepository.addMission(new Mission(Level.LEVEL1, "숫자야구게임"));

        MissionRepository.addMission(new Mission(Level.LEVEL2, "장바구니"));
        MissionRepository.addMission(new Mission(Level.LEVEL2, "결제"));
        MissionRepository.addMission(new Mission(Level.LEVEL2, "지하철노선도"));

        MissionRepository.addMission(new Mission(Level.LEVEL2, "성능개선"));
        MissionRepository.addMission(new Mission(Level.LEVEL2, "배포"));
    }
}
