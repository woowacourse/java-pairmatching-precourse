package pairmatching.model;

import java.util.HashSet;

public class CrewPair {
	private final String joinedName;
	private static final String DELIMITER = " : ";

	public CrewPair(String joinedName) {
		this.joinedName = joinedName;
	}

	public String toString() {
		return this.joinedName;
	}

	public boolean isSame(String joinedName) {
		HashSet<String> nowNameSet = new HashSet<>();
		int size = this.joinedName.split(DELIMITER).length;
		for (String eachName : this.joinedName.split(DELIMITER)) {
			nowNameSet.add(eachName);
		}
		for (String eachName : joinedName.split(DELIMITER)) {
			nowNameSet.add(eachName);
		}
		if (nowNameSet.size() == size) {
			return true;
		}
		return false;
	}

	public String getJoinedName() {
		return this.joinedName;
	}
}
