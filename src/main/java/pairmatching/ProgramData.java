package pairmatching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramData {
	private static List<String> backEndCrewNames;
	private static List<String> frontEndCrewNames;
	private static List<PairMatchRecorder> backEndLevel1History = new ArrayList<>();
	private static List<PairMatchRecorder> backEndLevel3History = new ArrayList<>();
	private static List<PairMatchRecorder> backEndLevel4History = new ArrayList<>();
	private static List<PairMatchRecorder> frontEndLevel1History = new ArrayList<>();
	private static List<PairMatchRecorder> frontEndLevel3History = new ArrayList<>();
	private static List<PairMatchRecorder> frontEndLevel4History = new ArrayList<>();

	ProgramData() throws IOException {
		backEndCrewNames = Crew.getCrewNames(Course.BACKEND);
		frontEndCrewNames = Crew.getCrewNames(Course.FRONTEND);

	}

	public static List<PairMatchRecorder> getMatchingHistory(Course course, Level level){
		List<PairMatchRecorder> checkList = new ArrayList<>();

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

		return checkList;
	}

	public static void setMatchingHistory(Course course, Level level, String mission, List<String> pairNames){
		List<PairMatchRecorder> history = getMatchingHistory(course, level);


		history.add(new PairMatchRecorder(course,level,mission,pairNames));
	}
	public static void deleteMatchingHistory(){
		backEndLevel1History.clear();
		backEndLevel3History.clear();
		backEndLevel4History.clear();
		frontEndLevel1History.clear();
		frontEndLevel3History.clear();
		frontEndLevel4History.clear();
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
