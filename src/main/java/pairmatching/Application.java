package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.models.Course;
import pairmatching.models.Mission;
import pairmatching.utils.MissionList;
import pairmatching.utils.NameList;
import pairmatching.utils.PairMatchingMessage;
import pairmatching.view.PairMachineInput;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO 구현 진행
		List<String> c = new ArrayList<>();
		c.add(Course.BACKEND.getName());
		c.add(Course.FRONTEND.getName());
		List<Mission> m = (new MissionList()).initMissionList();
		PairMachineInput in = new PairMachineInput();

		System.out.println(in.selectRematchPairOrNot());
    }
}
