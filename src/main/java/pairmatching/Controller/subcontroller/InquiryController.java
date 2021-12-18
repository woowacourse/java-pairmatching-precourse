package pairmatching.Controller.subcontroller;

import pairmatching.Controller.Controller;
import pairmatching.Model.Mission;
import pairmatching.Model.Missions;
import pairmatching.Service.MatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InquiryController implements Controller {
	private static final InputView inputView = new InputView();
	private static final OutputView outputView = new OutputView();

	@Override
	public void run() {
		outputView.printMessage(MatchingService.printCourseAndLevelInfo());
		try{
			Mission mission = Missions.findMission(inputView.enterCourseAndMissionInfo());
			outputView.printMessage(mission.getPairMatchingResult());
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}
}
