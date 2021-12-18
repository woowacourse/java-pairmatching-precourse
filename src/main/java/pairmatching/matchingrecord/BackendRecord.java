package pairmatching.matchingrecord;

import java.util.ArrayList;

public class BackendRecord {
	Leve1Record level1Record = new Leve1Record();
	Level2Record level2Record = new Level2Record();
	Level3Record level3Record = new Level3Record();
	Level4Record level4Record = new Level4Record();
	Level5Record level5Record = new Level5Record();

	public boolean checkDuplicateLevel1(ArrayList<ArrayList<String>> matchResult) {
		for (ArrayList<ArrayList<String>> level1 : level1Record.getLevel1Record()) {
			if (isDuplicate(level1, matchResult)) {
				return true;
			}
		}
		return false;
	}

	public boolean isDuplicate(ArrayList<ArrayList<String>> raw, ArrayList<ArrayList<String>> matchResult) {
		for (ArrayList<String> item1 : raw) {
			if (isContain(item1, matchResult)) {
				return true;
			}
		}
		return false;
	}

	public boolean isContain(ArrayList<String> item1, ArrayList<ArrayList<String>> matchResult) {
		for (ArrayList<String> item2 : matchResult) {
			if (isSame(item1, item2)) {
				return true;
			}
			;
		}
		return false;
	}

	public boolean isSame(ArrayList<String> str1, ArrayList<String> str2) {
		if (str1.containsAll(str2)) {
			return true;
		}
		return false;
	}

}
