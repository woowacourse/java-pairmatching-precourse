package pairmatching.view;

import java.util.List;

import pairmatching.message.Message;

public class OutputView {
	private static final String NAME_DIVISOR = " : ";


	public static void printProcessMissionLevel() {
		System.out.println();
		System.out.println(Message.PRINT_PROCESS_MISSION_LEVEL);
	}

	public static void printMatchingResult(List<String> matchingResult) {
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_RESULT);
		int index = 0;

		while(index < matchingResult.size()) {

			System.out.print(matchingResult.get(index) + NAME_DIVISOR);

			if(index + 2 < matchingResult.size()-1) {
				System.out.println(matchingResult.get(index+1));
			}

			if(index + 2 == matchingResult.size()-1) {
				System.out.print(matchingResult.get(index+1));
				System.out.println(NAME_DIVISOR + matchingResult.get(index+2));
				break;
			}

			index+=2;
		}
		System.out.println();
	}
}
