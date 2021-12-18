package pairmatching.matchingrecord;

import java.util.ArrayList;

public class Level4Record {

	ArrayList<ArrayList<String>> performanceImprovement = null;
	ArrayList<ArrayList<String>> distribution = null;

	public static boolean isPerformanceImprovementRecord = false;
	public static boolean isDistributionRecord = false;

	public void setMission(String mission, ArrayList<ArrayList<String>> matchResult) {
		if (mission.equals("성능개선")) {
			setPerformanceImprovement(matchResult);
			return;
		}
		if (mission.equals("배포")) {
			setDistribution(matchResult);
			return;
		}

	}

	public void setPerformanceImprovement(ArrayList<ArrayList<String>> matchResult) {
		this.performanceImprovement = matchResult;
	}

	public void setDistribution(ArrayList<ArrayList<String>> matchResult) {
		this.distribution = matchResult;
	}

	public ArrayList<ArrayList<ArrayList<String>>> getLevel4Record() {
		ArrayList<ArrayList<ArrayList<String>>> level4Record = new ArrayList<>();

		level4Record.add(performanceImprovement);
		level4Record.add(distribution);

		return level4Record;
	}

}
