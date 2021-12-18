package pairmatching;
import camp.nextstep.edu.missionutils.Console;

public class ProgramManager {

	public static boolean selectFunction(){
		//ProgramPrinter.selectFunction();
		String selection = Console.readLine();

		if(selection == "1"){
			//PairMatcher.pairMatch();
		} else if(selection == "2"){
			//ProgramManager.lookUpPair();
		} else if(selection == "3"){
			//ProgramManger.initializePair();
		} else if(selection == "Q"){
			return true;
		}

		return false;
	}
}
