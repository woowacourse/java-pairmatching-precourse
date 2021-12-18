package pairmatching;

import java.util.ArrayList;
import java.util.HashMap;
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
		// if(!missionMap.containsKey(level)){
		// 	List<String> list = new ArrayList<>();
		// 	list.add(missionName);
		// 	missionMap.put(level, list);
		// 	return;
		// }

		missionMap.get(level).add(missionName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("미션\n");
		for(Level level : missionMap.keySet()){
			sb.append("  - ").append(level.getLevelName()).append(": ");
			if(!missionMap.get(level).isEmpty()) {
				sb.append(String.join(" | ", missionMap.get(level)));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
