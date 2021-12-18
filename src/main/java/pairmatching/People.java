package pairmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class People {
	private String name;
	// 이름, [레벨...]
	private Map<String, List<String>> peopleWorkWithLevelRecord;

	People(String name) {
		this.name = name;
		initPeopleWorkWithLevelsRecord();
	}

	protected void initPeopleWorkWithLevelsRecord() {
		peopleWorkWithLevelRecord = new HashMap<>();
	}

	protected boolean checkAlreadyWorkInLevel(String partnerName, String level) {
		if (Boolean.FALSE.equals(peopleWorkWithLevelRecord.containsKey(partnerName))) {
			return false;
		}
		List<String> levelRecord = peopleWorkWithLevelRecord.get(partnerName);
		if (Boolean.FALSE.equals(levelRecord.contains(level))) {
			return false;
		}
		return true;
	}

	protected void recordPeoPleWorkInLevel(String partnerName, String level) {
		if (Boolean.FALSE.equals(peopleWorkWithLevelRecord.containsKey(partnerName))) {
			peopleWorkWithLevelRecord.put(partnerName, new ArrayList<>(Arrays.asList(level)));
		}
		peopleWorkWithLevelRecord.get(partnerName).add(level);
	}

	protected void removeRecord(String partnerName, String level) {
		if (Boolean.FALSE.equals(peopleWorkWithLevelRecord.containsKey(partnerName))) {
			return;
		}
		List<String> workWithLevelRecord = peopleWorkWithLevelRecord.get(partnerName);
		if (workWithLevelRecord.contains(level)) {
			workWithLevelRecord.remove(level);
			peopleWorkWithLevelRecord.put(partnerName, workWithLevelRecord);
		}
	}
}
