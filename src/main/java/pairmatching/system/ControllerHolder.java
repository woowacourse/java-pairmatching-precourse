package pairmatching.system;

import pairmatching.controller.*;
import pairmatching.vo.ControllerName;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private final static Map<ControllerName, Controller> controllers = new HashMap<>();

    static {
        initializeSetupControllers();
        controllers.put(ControllerName.MAIN, new MainController());
        controllers.put(ControllerName.MATCHING, new MatchingController());
        controllers.put(ControllerName.FIND, new FindingController());
        controllers.put(ControllerName.RESET, new ResetingController());
    }

    private static void initializeSetupControllers() {
        controllers.put(ControllerName.SETUP_MISSION, new SetupController());
        controllers.put(ControllerName.SETUP_CREW, new SetupCrewController());
    }

    public static Controller get(ControllerName controllerName) {
        return controllers.get(controllerName);
    }
}
