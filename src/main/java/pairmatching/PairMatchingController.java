package pairmatching;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    static CrewRepository crewRepository = new CrewRepository();

    public static void run() {
        initCrewRepsoitory();
        proceed();
    }

    private static void initCrewRepsoitory() {
        crewRepository.initBackend("src/main/resources/backend-crew.md");
        crewRepository.initFrontend("src/main/resources/frontend-crew.md");
    }

    private static void proceed() {
        while (true) {
            String validateMenu = getValidateMenu();
            if (validateMenu.equals("Q")) {
                break;
            }
        }
    }

    private static String getValidateMenu() {
        try {
            return PairMatchingService.getValidateMenu(InputView.readMenu());
        } catch (IllegalArgumentException error) {
            OutputView.printException(error);
            return getValidateMenu();
        }
    }
}
