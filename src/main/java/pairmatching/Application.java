package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.controller.InputController;
import pairmatching.controller.PairMatchingController;
import pairmatching.models.Course;
import pairmatching.models.Mission;
import pairmatching.utils.CourseList;
import pairmatching.utils.DataValidation;
import pairmatching.utils.MissionList;
import pairmatching.utils.NameList;
import pairmatching.utils.PairMatchingMessage;
import pairmatching.view.PairMachineInput;
import pairmatching.view.PairMachiningOutput;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO 구현 진행
		// List<String> c = new ArrayList<>();
		// c.add(Course.BACKEND.getName());
		// c.add(Course.FRONTEND.getName());
		// List<Mission> m = (new MissionList()).initMissionList();
		// PairMachineInput in = new PairMachineInput();
		// InputController ic = new InputController(in, new DataValidation());
		// ic.selectRematchPairOrNot();
        PairMatchingController c = new PairMatchingController(new NameList(), new PairMachiningOutput());
        c.printMachineResult();
    }
}
