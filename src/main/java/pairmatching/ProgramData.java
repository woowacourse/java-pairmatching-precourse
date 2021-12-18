package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramData {
	private static List<String> backEndCrewNames;
	private static List<String> frontEndCrewNames;
	private static List<PairMatcher> backEndLevel1History;
	private static List<PairMatcher> backEndLevel3History;
	private static List<PairMatcher> backEndLevel4History;
	private static List<PairMatcher> frontEndLevel1History;
	private static List<PairMatcher> frontEndLevel3History;
	private static List<PairMatcher> frontEndLevel4History;

	ProgramData() throws IOException {
		backEndCrewNames = Crew.getCrewNames(Course.BACKEND);
		frontEndCrewNames = Crew.getCrewNames(Course.FRONTEND);

	}

	public boolean checkDuplicatedPair(Course course, Level level, String mission, HashMap<String, String> pairMap){
		List<PairMatcher> checkList = new ArrayList<>();

		if(course == Course.BACKEND){
			if(level == Level.LEVEL1){
				checkList = backEndLevel1History;
			} else if(level == Level.LEVEL3) {
				checkList = backEndLevel3History;
			} else if(level == Level.LEVEL4){
				checkList = backEndLevel4History;
			}
		} else if(course == Course.FRONTEND){
			if(level == Level.LEVEL1){
				checkList = frontEndLevel1History;
			} else if(level == Level.LEVEL3) {
				checkList = frontEndLevel3History;
			} else if(level == Level.LEVEL4){
				checkList = frontEndLevel4History;
			}
		}

		return true;
	}

	public static List<String> getCrewNames(Course course){
		if(course == Course.BACKEND){
			return backEndCrewNames;
		} else if(course == Course.FRONTEND){
			return frontEndCrewNames;
		}
		return null;
	}
}
