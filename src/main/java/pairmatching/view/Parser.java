package pairmatching.view;

public class Parser {
	public boolean parseToIsWantToMatch(String value) {
		if (value.equals("아니오")) {
			return false;
		}
		return true;
	}

	public String parseToCourse(String information) {
		return information.split(",")[0].trim();
	}

	public String parseToLevel(String information) {
		return information.split(",")[1].trim();
	}

	public String parseToMission(String information) {
		return information.split(",")[2].trim();
	}
}
