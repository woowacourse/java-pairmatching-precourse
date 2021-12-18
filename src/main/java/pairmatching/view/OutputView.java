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
		matchingResult.forEach(name -> System.out.println(name));
		System.out.println();
		System.out.println(Message.PRINT_MATCHING_RESULT);
		int index = 0;

		while(index < matchingResult.size()) {

			System.out.print(matchingResult.get(index) + NAME_DIVISOR);
			System.out.print(matchingResult.get(index+1));

			if(index + 2 == matchingResult.size()-1) {
				System.out.println(NAME_DIVISOR + matchingResult.get(index+2));
				break;
			}

			System.out.println();

			index+=2;
		}

		System.out.println();
		System.out.println();
	}

	public static void printReMatchingQuery() {
		System.out.println(Message.PRINT_QUERY_MATCHING);
	}

	public static void printCompleteInitialize() {
		System.out.println(Message.PRINT_COMPLETE_INITIALIZE);
		System.out.println();
	}
}
