package pairmatching;

public class Ui {

	protected void printMessage(String message) {
		System.out.print(message);
	}

	protected String printQuestion(String message) {
		printMessage(message);
		return camp.nextstep.edu.missionutils.Console.readLine();
	}
}
