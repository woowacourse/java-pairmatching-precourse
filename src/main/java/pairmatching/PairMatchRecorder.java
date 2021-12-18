package pairmatching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchRecorder {
	private Course course;
	private Level level;
	private String mission;
	private List<String> pairMatchHistory;

	PairMatchRecorder(Course course, Level level, String mission){
		this.course=course;
		this.level = level;
		this.mission = mission;
	}

	private boolean checkDuplicatedPair(List<String> recentMatchedPair){
		for(int i = 0; i < recentMatchedPair.size(); i++){
			String recentMatchedPairName1 = new String();
			String recentMatchedPairName2 = new String();

			if(i / 2 == 0){
				recentMatchedPairName1 = recentMatchedPair.get(i+1);
			} else if(i / 2 == 1){
				recentMatchedPairName2 = recentMatchedPair.get(i -1);
			}
			if(recentMatchedPair.size() / 2 != 0 && i ==recentMatchedPair.size()-3)
			{
				recentMatchedPairName2 = recentMatchedPair.get(i + 2);
			} else if(recentMatchedPair.size() /2 != 0 && i == recentMatchedPair.size()-2){
				recentMatchedPairName2 = recentMatchedPair.get(i + 1);
			} else if(recentMatchedPair.size() /2 != 0 && i == recentMatchedPair.size() -1){
				recentMatchedPairName2 = recentMatchedPair.get(i - 2);
			}

			String pastMatchedPairName1 = new String();
			String pastMatchedPairName2 = new String();

			if(i / 2 == 0){
				pastMatchedPairName1 = pairMatchHistory.get(i+1);
			} else if(i / 2 == 1){
				pastMatchedPairName1 = pairMatchHistory.get(i -1);
			}
			if(pairMatchHistory.size() / 2 != 0 && i ==pairMatchHistory.size()-3)
			{
				pastMatchedPairName2 = pairMatchHistory.get(i + 2);
			} else if(pairMatchHistory.size() /2 != 0 && i == pairMatchHistory.size()-2){
				pastMatchedPairName2 = pairMatchHistory.get(i + 1);
			} else if(pairMatchHistory.size() /2 != 0 && i == pairMatchHistory.size() -1){
				pastMatchedPairName2 = pairMatchHistory.get(i - 2);
			}

			if(recentMatchedPairName1 == pastMatchedPairName1){
				return false;
			}else if(recentMatchedPairName1 == pastMatchedPairName2){
				return false;
			}

			if(recentMatchedPairName2 == pastMatchedPairName1){
				return false;
			} else if(recentMatchedPairName2 == pastMatchedPairName2){
				return false;
			}

		}

		return true;
	}
}
