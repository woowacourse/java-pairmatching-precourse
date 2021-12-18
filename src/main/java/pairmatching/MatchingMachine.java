package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.MainView;
import pairmatching.domain.Matching;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingMachine {

	Missions missions;
	Crews crews;

	public MatchingMachine(){
		this.missions = new Missions();
		this.crews = new Crews();
	}
	public void run(){
		MainView mainView = MainView.valueOf(InputView.askFeature());
		runFeature(mainView);
	}

	private void runFeature(MainView mainView) {
		if (mainView.isMatching()){
			matching();
			return;
		}
		// if(mainView.isSearching()){
		// 	searching();
		// 	return;
		// }
		// if(mainView.isInitializing()){
		// 	initializing();
		// 	return;
		// }
		// if(mainView.isExit()){
		// 	exit();
		// }
	}

	private void matching(){
		Matching matching = new Matching();
		Set<List> pairsCrew = new HashSet<>();
		List<String> crewNames = new ArrayList<>();
		List<String> matchInformation = Arrays.asList((InputView.askWantedMatchingInformation().split(", ")));
		Mission mission = missions.getMission(Course.getCourse(matchInformation.get(0)), Level.getLevel(matchInformation.get(1)), matchInformation.get(2));
		crewNames = crews.getCrews(Course.getCourse(matchInformation.get(0)).getName());
		if(mission.getPairCrews() == null) {
			pairsCrew = matching.matching(crewNames);
			OutputView.printPairCrews(pairsCrew);
		}
		if(mission.getPairCrews() != null){
			Set<Map> prePairCrew = mission.getPairCrews();
			for(int i = 0; i < pairsCrew.size(); i++) {
				;
			}
		}
	}
}
//백엔드, 레벨1, 자동차경주