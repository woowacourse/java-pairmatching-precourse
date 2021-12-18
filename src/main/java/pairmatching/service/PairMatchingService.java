package pairmatching.service;

public class PairMatchingService {

	public void start(String rawInfo) {
		String[] userInput = splitCourseInfo(rawInfo);
		for (String s : userInput) {
			System.out.println(s);
		}
	}

	public String[] splitCourseInfo(String rawInfo) {
		String[] cleanInfo = rawInfo.split(", ");
		return cleanInfo;

	}
}
