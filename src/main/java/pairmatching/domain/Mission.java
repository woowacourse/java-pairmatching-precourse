package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mission {
	private Map<Level, List<String>> missionMap;

	public Mission(){
		missionMap = new TreeMap<>((o1,o2) -> o1.getLevel()-o2.getLevel());
		Level.getLevelList().stream()
			.forEach(s -> missionMap.put(s, new ArrayList<>()));
	}

	public void insertMissionByLevel(Level level, String missionName){
		missionMap.get(level).add(missionName);
	}

	public List<String> getMissionListByLevel(Level level){
		return missionMap.get(level);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("미션\n");
		for(Level level : missionMap.keySet()){
			sb.append("  - ").append(level.getName()).append(": ");
			if(!missionMap.get(level).isEmpty()) {
				sb.append(String.join(" | ", missionMap.get(level)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
